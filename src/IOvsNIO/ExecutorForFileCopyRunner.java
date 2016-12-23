package IOvsNIO;

import MemoryMappedFile.MemoryMappedFileForHugeMatrix.LargeDoubleMatrixSample;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


//Shows advantage of FileChannel class
public class ExecutorForFileCopyRunner {
    private static final String A_FILE = "a.bin";
    private static final String B_FILE = "b.bin";

    public static void main(String[] args) throws Exception {
        File file1 = new File(A_FILE);
        file1.createNewFile();
        LargeDoubleMatrixSample matrix = new LargeDoubleMatrixSample(A_FILE, 100 * 100, 100 * 100);//700+mb file
        File file2 = new File(B_FILE);

        try {
            new ExecutorForFileCopyRunner().testCopy();
        } finally {
            file1.delete();
            file2.delete();
        }
    }

    void testCopy() throws Exception {
        ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors
                .newCachedThreadPool();
        final long start = System.currentTimeMillis();
        Callable<Object> task = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                try {
                    copyWithStreams(A_FILE, B_FILE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Call really finished after: " +
                        (System.currentTimeMillis() - start));
                return null;
            }

            //best
            private void copyNioBuffered(String in, String out) throws IOException {
                FileChannel fin = new FileInputStream(in).getChannel();
                FileChannel fout = new FileOutputStream(out).getChannel();

                ByteBuffer buff = ByteBuffer.allocate(4096);
                while (fin.read(buff) != -1 || buff.position() > 0) {
                    buff.flip();
                    fout.write(buff);
                    buff.compact();
                }

                fin.close();
                fout.close();
            }

            //good but not the best
            private void copyWithChannel(String in, String out) throws IOException {
                FileChannel fin = new FileInputStream(in).getChannel();
                FileChannel fout = new FileOutputStream(out).getChannel();

                fout.transferFrom(fin, 0, new File(in).length());

                fin.close();
                fout.close();
            }

            //inaccurate
            private void copyWithStreams(String in, String out) throws IOException {
                FileInputStream fin = new FileInputStream(in);
                FileOutputStream fout = new FileOutputStream(out);

                byte[] buf = new byte[4096];
                int read;

                /*//usual approach when copying to b file are not working properly
                while((read = fin.read(buf))> -1){
                    fout.write(buf, 0, read);
                }*/

                while ((read = fin.read(buf)) > -1) {
                    fout.write(buf, 0, read);
                    if (Thread.interrupted()) {
                        throw new IOException("Thread interrupted, cancelling ");
                    }
                }

                fin.close();
                fout.close();
            }

            private void copy(String in, String out) throws IOException {
                FileInputStream fin = new FileInputStream(in);
                FileOutputStream fout = new FileOutputStream(out);

                byte[] buf = new byte[4096];
                int read;

                //usual approach when copying to b file are not working properly
                while ((read = fin.read(buf)) > -1) {
                    fout.write(buf, 0, read);
                }


                fin.close();
                fout.close();
            }
        };
        Collection<Callable<Object>> taskWrapper = Arrays.asList(task);
        List<Future<Object>> futures = exec.invokeAll(taskWrapper, 3000, TimeUnit.MILLISECONDS);
        System.out.println("invokeAll finished after: " + (System.currentTimeMillis() - start));
        System.out.println("Future.isCancelled? " + futures.get(0).isCancelled());
        Thread.sleep(20);
        System.out.println("Threads still active: " + exec.getActiveCount());
    }
}
