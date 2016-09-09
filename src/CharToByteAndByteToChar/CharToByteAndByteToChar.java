package CharToByteAndByteToChar;

import org.perf4j.StopWatch;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Random;

/**
 * Created by islabukhin on 09.09.16.
 */
public class CharToByteAndByteToChar {


    public static byte[] stringToBytesASCII(String str) {
        byte[] b = new byte[str.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) str.charAt(i);
        }
        return b;
    }

    /*public static byte[] stringToBytesASCII(String str){
        char[] buffer = str.toCharArray();
        byte[] bytes = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            bytes[i] = (byte) buffer[i];
        }
        return bytes;
    }*/

    //best

    public static byte[] stringToBytesUTFCustom(String str) {
        byte[] b = new byte[str.length() << 1];
        for(int i = 0; i < str.length(); i++) {
            char strChar = str.charAt(i);
            int bpos = i << 1;
            b[bpos] = (byte) ((strChar&0xFF00)>>8);
            b[bpos + 1] = (byte) (strChar&0x00FF);
        }
        return b;
    }

    //best
    public static String bytesToStringUTFCustom(byte[] bytes) {
        char[] buffer = new char[bytes.length >> 1];
        for(int i = 0; i < buffer.length; i++) {
            int bpos = i << 1;
            char c = (char)(((bytes[bpos]&0x00FF)<<8) + (bytes[bpos+1]&0x00FF));
            buffer[i] = c;
        }
        return new String(buffer);
    }

    public static byte[] stringToBytesUTFNIO(String str) {
        char[] buffer = str.toCharArray();
        byte[] b = new byte[buffer.length << 1];
        CharBuffer cBuffer = ByteBuffer.wrap(b).asCharBuffer();
        for(int i = 0; i < buffer.length; i++)
            cBuffer.put(buffer[i]);
        return b;
    }



    public static String bytesToStringUTFNIO(byte[] bytes) {
        CharBuffer cBuffer = ByteBuffer.wrap(bytes).asCharBuffer();
        return cBuffer.toString();
    }

    public static void main(String[] args) {
        String text = "qwertyuiop[]asdfghjkl;'zxcvbnm,./1234567890-=";
        int cycles = 1000000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < cycles; i++) {
            byte[] bytes = stringToBytesUTFCustom(text);
            text = bytesToStringUTFCustom(bytes);
        }
        stopWatch.stop();
        System.out.println("Custom:" + stopWatch.getElapsedTime());

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        for (int i = 0; i < cycles; i++) {
            byte[] bytes = stringToBytesUTFNIO(text);
            text = bytesToStringUTFNIO(bytes);
        }
        stopWatch2.stop();
        System.out.println("UTFNIO:" + stopWatch2.getElapsedTime());
    }

    //for text with <1000000 chars custom is better

}
