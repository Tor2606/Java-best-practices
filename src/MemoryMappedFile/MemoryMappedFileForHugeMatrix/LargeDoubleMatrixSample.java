package MemoryMappedFile.MemoryMappedFileForHugeMatrix;

import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class LargeDoubleMatrixSample implements Closeable {

    private static final int MAPPING_SIZE = 1 << 30;//1073741824 - 1gb
    private final RandomAccessFile randomAccessFile;//good, when you need to move inside the file.xml (ex. with matrix) and change it's part
    private final int width;
    private final int height;
    private final List<MappedByteBuffer> mappings = newArrayList();

    public LargeDoubleMatrixSample(String filename, int width, int height) throws IOException {
        this.randomAccessFile = new RandomAccessFile(filename, "rw");//rw = read + write
        try {
            this.width = width;
            this.height = height;
            long size = 8L * width * height; //8L = 1 simple(utf-8) char size
            for (long offset = 0; offset < size; offset += MAPPING_SIZE) {
                long size2 = Math.min(size - offset, MAPPING_SIZE);
                mappings.add(randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, offset, size2));
            }
        } catch (IOException e) {
            randomAccessFile.close();
            throw e;
        }
    }

    protected long position(int x, int y) {
        return (long) y * width + x;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public double get(int x, int y) {
        assert x >= 0 && x < width;
        assert y >= 0 && y < height;
        long p = position(x, y) * 8;
        int mapN = (int) (p / MAPPING_SIZE);
        int offN = (int) (p % MAPPING_SIZE);
        return mappings.get(mapN).getDouble(offN);
    }

    public void set(int x, int y, double d) {
        assert x >= 0 && x < width;
        assert y >= 0 && y < height;
        long p = position(x, y) * 8;
        int mapN = (int) (p / MAPPING_SIZE);
        int offN = (int) (p % MAPPING_SIZE);
        mappings.get(mapN).putDouble(offN, d);
    }

    @Override
    public void close() throws IOException {
        mappings.stream().forEach((el)->clean(el));
        randomAccessFile.close();
    }

    private void clean(MappedByteBuffer el) {
        if(el==null) return;
        Cleaner cleaner = ((DirectBuffer) el).cleaner();
        if(cleaner!=null) cleaner.clean();
    }
}
