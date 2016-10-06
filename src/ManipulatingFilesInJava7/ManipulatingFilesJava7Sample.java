package ManipulatingFilesInJava7;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by islabukhin on 06.10.16.
 */


public class ManipulatingFilesJava7Sample {
    public static void main(String[] args) throws IOException {
        Path target = Paths.get("/home/islabukhin/IdeaProjects/Java-best-practice/src/ManipulatingFilesInJava7/fileSample.txt");
        Files.deleteIfExists(target);
        Path file = Files.createFile(target);
        IOUtils.write("Some text", new FileOutputStream(file.toFile()));

        Path directoryTarget = Paths.get("/home/islabukhin/IdeaProjects/Java-best-practice/src/ManipulatingFilesInJava7/samples");
        Files.deleteIfExists(directoryTarget);
        Path directory = Files.createDirectory(directoryTarget);

        Path fileCopyPath = Paths.get("/home/islabukhin/IdeaProjects/Java-best-practice/src/ManipulatingFilesInJava7/samples/copy.txt");
        Path newFile = Files.copy(target,fileCopyPath);//move is possible too
        System.out.println(Files.readAllLines(fileCopyPath));
        Files.delete(fileCopyPath);
    }
}
