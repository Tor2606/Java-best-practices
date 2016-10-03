package ApacheCommons;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Collection;

public class ArchiveAndCompressSample {
    private static final String FILE_PATH = "/home/islabukhin/IdeaProjects/Java-best-practice/src/ApacheCommons/compressed.zip";
    private static final String FOLDER_PATH = "/home/islabukhin/IdeaProjects/Java-best-practice/src/ApacheCommons/directory";

    /*The stream classes all wrap around streams provided by the calling code and they work
    on them directly without any additional buffering. On the other hand most of them will
    benefit from buffering so it is highly recommended that users wrap their stream in
    Buffered(In|Out)putStreams before using the Commons Compress API.*/

    public static void main(String[] args) throws IOException, CompressorException, ArchiveException {
        File file = new File(FILE_PATH);
        File folder = new File(FOLDER_PATH);
        file.delete();

        addFilesToZip(file, folder);
    }

    private static void addFilesToZip(File file, File folder) throws IOException, ArchiveException {
        OutputStream archiveStream = new FileOutputStream(file);
        ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, archiveStream);

        Collection<File> fileList = FileUtils.listFiles(folder, null, true);

        for (File iterFile : fileList) {

            ZipArchiveEntry entry = new ZipArchiveEntry(iterFile.getPath());

            archive.putArchiveEntry(entry);
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(iterFile));

            //byte[] contentOfEntry = IOUtils.toByteArray(input);
            //archive.write(contentOfEntry);
            // it's equivalent to next

            IOUtils.copy(input, archive);

            input.close();
            archive.closeArchiveEntry();
        }

        archive.finish();
        archiveStream.close();
    }
}
