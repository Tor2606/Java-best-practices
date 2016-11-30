package FileFilteringSample;

import java.io.IOException;
import java.nio.file.*;

public class FileFilteringSample {
    public static void main(String[] args) {
        //scan("C:\\Users\\isla\\IdeaProjects\\Java-best-practices\\src\\FileFilteringSample\\folder", "*.txt");
        scanWithCouplePatterns("C:\\Users\\isla\\IdeaProjects\\Java-best-practices\\src\\FileFilteringSample\\folder", "*{png,jpg}");
    }

    private static void scan(String folder, String pattern) {
        Path dir = Paths.get(folder);
        if (checkIfNotExist(dir)) {
            System.out.println("Directory doesn't exist!");
        }

        try (DirectoryStream directoryStream = Files.newDirectoryStream(dir, pattern)) {
            int count = 0;
            for (Object path1 : directoryStream) {
                Path path = (Path) path1;
                System.out.println(path.getFileName());
                count++;
            }
            System.out.println("");
            System.out.printf("Files matches the pattern", count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanWithCouplePatterns(String folder, String... patterns) {
        Path dir = Paths.get(folder);
        if (checkIfNotExist(dir)) {
            System.out.println("No such directory!");
            return;
        }
        if (patterns == null || patterns.length < 1) {
            System.out.println("No pattern");
            return;
        }

        PathMatcher extraFilter1 = null;
        PathMatcher extraFilter2 = null;
        if (patterns.length > 1 && patterns[1] != null) {
            extraFilter1 = FileSystems.getDefault().getPathMatcher(patterns[1]);
        }
        if (patterns.length > 2 && patterns[2] != null) {
            extraFilter2 = FileSystems.getDefault().getPathMatcher(patterns[2]);
        }
        try (DirectoryStream directoryStream = Files.newDirectoryStream(dir, patterns[0])) {
            int count = 0;
            for (Object pathO : directoryStream) {
                Path path = (Path) pathO;
                System.out.println("Evaluating" + path.getFileName());
                if(extraFilter1!=null&&extraFilter1.matches(path.getFileName())){
                    System.out.println("Match found, do");
                }
                if(extraFilter2!=null && extraFilter2.matches(path.getFileName())){
                    System.out.println("Match found do another things");
                }
                count++;
            }
            System.out.println();
            System.out.printf("%d Files match the global pattern\n", count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean checkIfNotExist(Path dir) {
        return !Files.exists(dir) || !Files.isDirectory(dir);
    }
}
