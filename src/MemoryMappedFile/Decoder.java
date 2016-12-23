package MemoryMappedFile;

import java.nio.ByteBuffer;

public interface Decoder<T> {
    public T decode(ByteBuffer byteBuffer );
}
