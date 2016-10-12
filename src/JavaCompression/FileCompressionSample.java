package JavaCompression;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.*;

/**
 * Created by islabukhin on 28.09.16.
 */
public class FileCompressionSample {
    private static final int BUFFER = 256;
    private static final String PATH_SEPARATOR = "//";

    private FileCompressionSample() {
    }

    ;

    public static void zipFilesInPath(final String fileName, final String foulderPath) throws IOException {
        final FileOutputStream outputStream = new FileOutputStream(fileName);
        final ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(outputStream));
        try {
            byte[] data = new byte[BUFFER];
            final File folder = new File(foulderPath);
            final List<String> filesList = Arrays.asList(folder.list());
            for (String iterFile : filesList) {
                final FileInputStream fileInputStream = new FileInputStream(foulderPath + PATH_SEPARATOR + iterFile);
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, BUFFER);
                zipOutputStream.putNextEntry(new ZipEntry(iterFile));
                int counter;
                while ((counter = bufferedInputStream.read(data, 0, BUFFER)) != -1) {
                    zipOutputStream.write(data, 0, counter);
                }
                bufferedInputStream.close();
                fileInputStream.close();
            }
        } finally {
            zipOutputStream.close();
            outputStream.close();
        }
    }

    public static long zipFilesInPathWithCheckSum(final String fileName, final String foulderPath) throws IOException {
        final FileOutputStream outputStream = new FileOutputStream(fileName);
        final CheckedOutputStream checkStream = new CheckedOutputStream(outputStream, new CRC32());
        final ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(checkStream));
        try {
            byte[] data = new byte[BUFFER];
            final File folder = new File(foulderPath);
            final List<String> filesList = Arrays.asList(folder.list());
            for (String iterFile : filesList) {
                final FileInputStream fileInputStream = new FileInputStream(foulderPath + PATH_SEPARATOR + iterFile);
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, BUFFER);
                zipOutputStream.putNextEntry(new ZipEntry(iterFile));
                int counter;
                while ((counter = bufferedInputStream.read(data, 0, BUFFER)) != -1) {
                    zipOutputStream.write(data, 0, counter);
                }

                bufferedInputStream.close();
            }
        } finally {
            zipOutputStream.close();
            checkStream.close();
            outputStream.flush();
            outputStream.close();
        }

        return checkStream.getChecksum().getValue();
    }


    public static void unzipToPath(final String zipFileName, final String fileExtractPath) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(zipFileName);
        final ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
        try {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                int counter;
                byte[] data = new byte[BUFFER];
                final FileOutputStream fileOutputStream = new FileOutputStream(fileExtractPath + PATH_SEPARATOR + zipEntry.getName());
                final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BUFFER);
                while ((counter = zipInputStream.read(data, 0, BUFFER)) != -1) {
                    bufferedOutputStream.write(data, 0, counter);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        } finally {
            zipInputStream.close();
            fileInputStream.close();
        }
    }

    public static boolean unzipToPathWithCheckSum(final String zipFileName, final String fileExtractPath, final long checksum) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(zipFileName);
        final CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
        final ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(checkedInputStream));

        try {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                int counter;
                byte[] data = new byte[BUFFER];
                final FileOutputStream fileOutputStream = new FileOutputStream(fileExtractPath + PATH_SEPARATOR + zipEntry.getName());
                final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BUFFER);
                while ((counter = zipInputStream.read(data, 0, BUFFER)) != -1) {
                    bufferedOutputStream.write(data, 0, counter);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        } finally {
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        }

        return (checkedInputStream.getChecksum().getValue() == checksum) ? true : false;
    }
}
/*

GZIPInputStream – An input stream filter for reading compressed data in the GZIP file.xml format.
GZIPOutputStream – An output stream filter for writing compressed data in the GZIP file.xml format.
Default internal buffer of 512, use BufferedOutputStream if you require more.
*/
