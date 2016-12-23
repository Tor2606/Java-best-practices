package ByteBufferSample;

import java.nio.ByteBuffer;

public class ByteBufferSample {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = fromByteArray(new byte[]{1,2,3,4,5});
        System.out.println("Get element from byte buffer: " + byteBuffer.get(0));
        ByteBuffer byteBuffer1 = fromByteArray(new byte[]{'v','a', 's', 'y', 'a'});
        System.out.println("Get bytes to String: " + toString(byteBuffer1));
    }

    public static ByteBuffer fromByteArray(byte[] bytes){
        final ByteBuffer ret = ByteBuffer.wrap(new byte[bytes.length]);
        ret.put(bytes);
        ret.flip();//return position to the null
        return ret;
    }

    public static String toString(ByteBuffer bb){
        final byte[] bytes = new byte[bb.remaining()];

        bb.duplicate().get(bytes);//because don't mutate bb
        return new String(bytes);
    }


}
