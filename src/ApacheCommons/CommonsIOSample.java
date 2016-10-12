package ApacheCommons;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Created by islabukhin on 04.10.16.
 */
public class CommonsIOSample {

    private static final String FILE_PATH = "/home/islabukhin/IdeaProjects/Java-best-practice/src/ApacheCommons/directory/compressionFile.txt";
    public static final String FOLDER_PATH = "/home/islabukhin/IdeaProjects/Java-best-practice/src/ApacheCommons/directory";
    private static final String URL_ADDRESS = "http://www.ipinfo.io/89.22.47.180/json";

    public static void main(String[] args) throws IOException {
        //printResponseBodyFromUrl("http://commons.apache.org");
        printResponseBodyFromUrlLessCode(URL_ADDRESS);
        //printResponseBodyFromUrl(URL_ADDRESS);

        //FileUtils sample
        List linesList = readLinesFromFile(FILE_PATH);
        linesList.stream().forEach(it -> System.out.println("Line:" + it));

        //FileSystemUtils
        long freeSpace = FileSystemUtils.freeSpaceKb();
        System.out.println(freeSpace);
    }

    private static List readLinesFromFile(String address) throws IOException {
        File file = new File(address);
        List lines = FileUtils.readLines(file, "UTF-8");
        return lines;
    }

    private static void printResponseBodyFromUrlLessCode(String urlAddress) throws IOException {
        InputStream in = new URL(urlAddress).openStream();
        try {
            System.out.println(IOUtils.toString(in));
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    private static void printResponseBodyFromUrl(String urlAddress) throws IOException {
        InputStream in = new URL(urlAddress).openStream();
        try {
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(inR);
            String line;
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            in.close();
        }
    }
}
