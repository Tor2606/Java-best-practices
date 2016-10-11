package CopyAndMoveFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyAndMoveFilesExample {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("/home/islabukhin/IdeaProjects/Java-best-practice/src/CopyAndMoveFilesAndDirectories/directory");
        System.out.println(path);

        Path path2 = Paths.get("/home/islabukhin/IdeaProjects/Java-best-practice/src/CopyAndMoveFilesAndDirectories/directory2");
        System.out.println(path2);

        File file3 = new File("/home/islabukhin/IdeaProjects/Java-best-practice/src/CopyAndMoveFilesAndDirectories/directory3");
        Path path3 = file3.toPath();
        System.out.println(path3);

        Path path4 = Paths.get("/home/islabukhin/IdeaProjects/Java-best-practice/src/CopyAndMoveFilesAndDirectories/directory");
        System.out.println(path4);

        Path resolved = path4.resolve("file1.txt");
        //Path resolved = Paths.get("directory/file1.txt");
        System.out.println(resolved);
        Path relative = resolved.relativize(path4);
        System.out.println(relative);

        System.out.println(path.getFileName());
        System.out.println(resolved.getFileName());

        /*// base Path string "/usr"
        Path base = Paths.get("/usr");
        // foo Path string "/usr/foo"
        Path foo = base.resolve("foo");
        // bar Path string "/usr/foo/bar"
        Path bar = foo.resolve("bar");
        // relative Path string "foo/bar"
        Path relative1 = base.relativize(bar);*/

        /*Here is the list of available options for Files.copy:
        LinkOption.NOFOLLOW_LINKS
        StandardCopyOption.COPY_ATTRIBUTES
        StandardCopyOption.REPLACE_EXISTING*/

        /*Moving files options:
        StandardCopyOption.REPLACE_EXISTING
        StandardCopyOption.ATOMIC_MOVE*/
        Path destinationFile = path.resolve("file2.txt");
        Files.copy(resolved, destinationFile);
    }
}
