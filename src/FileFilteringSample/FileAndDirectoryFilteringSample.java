package FileFilteringSample;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAndDirectoryFilteringSample {
    public static void main(String[] args) {
        scanWithFilters("C:\\Users\\isla\\IdeaProjects\\Java-best-practices\\src\\FileFilteringSample\\folder2", getDirectoriesFilter());
        scanWithFilters("C:\\Users\\isla\\IdeaProjects\\Java-best-practices\\src\\FileFilteringSample\\folder2", getHiddenFilesFilter());
    }

    public static void scanWithFilters(String folder, DirectoryStream.Filter<Path> filter){
        Path dir = Paths.get(folder);

        if(checkIfNotExist(dir)){
            System.out.println("No Such directory");
            return;
        }

        if (filter == null){
            System.out.println("Please provide a filter");
            return;
        }

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir, filter)) {
            int count = 0;
            for(Object ob : ds){
                Path path = (Path) ob;
                System.out.println(path.getFileName());
                count++;
            }
            System.out.println();
            System.out.printf("%d entries were accepted\n", count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DirectoryStream.Filter<Path> getDirectoriesFilter(){
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){

            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };
        return filter;
    }

    public static DirectoryStream.Filter<Path> getHiddenFilesFilter(){
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){

            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isHidden(entry);
            }
        };
        return filter;
    }

    private static boolean checkIfNotExist(Path dir) {
        return !Files.exists(dir) || !Files.isDirectory(dir);
    }
}
