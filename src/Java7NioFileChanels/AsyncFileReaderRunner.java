package Java7NioFileChanels;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncFileReaderRunner {

    private static AsynchronousFileChannel fileChannel;

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        try {
            fileChannel = AsynchronousFileChannel.open(Paths.get("/home/islabukhin/IdeaProjects/Java-best-practice/src/Java7NioFileChanels/file.txt"),
                    StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            Future<Integer> future = fileChannel.write(ByteBuffer.wrap("Hello".getBytes()), 0L);
            future.get();
            System.out.println(IOUtils.toString(new FileInputStream(new File("/home/islabukhin/IdeaProjects/Java-best-practice/src/Java7NioFileChanels/file.txt"))));
            Thread thread = new Thread(() -> {
                try {
                    future.get();
                    System.out.println(IOUtils.toString(new FileInputStream(new File("/home/islabukhin/IdeaProjects/Java-best-practice/src/Java7NioFileChanels/file.txt"))));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileChannel.close();
        }
    }
}
