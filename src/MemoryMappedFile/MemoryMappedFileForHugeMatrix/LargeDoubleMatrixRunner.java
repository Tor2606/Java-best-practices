package MemoryMappedFile.MemoryMappedFileForHugeMatrix;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LargeDoubleMatrixRunner {
    @Test
    public void getSetMatrixTest() throws IOException {
        //it's possible to create matrix as big, as system(hd) allows
        long start = System.nanoTime();
        final long used0 = usedMemory();
        LargeDoubleMatrixSample matrix = new LargeDoubleMatrixSample("ldm.test", 10 * 10, 10 * 10); //100*100, 100*100
        for (int i = 0; i < matrix.width(); i++){
            matrix.set(i,i,i);
        }
        for (int i = 0; i < matrix.width(); i++) {
            assertEquals(i, matrix.get(i,i),0.0);
        }
        long time = System.nanoTime() - start;
        final long used = usedMemory() - used0;
        if(used == 0)
            System.out.println("You need to use -XX;-use TLAB to see small changes in memory usage");
        System.out.printf("Setting the diagonal took %,d ms, Heap used is %,d KB%n",
                time / 1000 / 1000, used / 1024);
        matrix.close();
    }

    private static long usedMemory() {
        return Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory();
    }
}
