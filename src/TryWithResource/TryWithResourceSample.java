package TryWithResource;

import java.io.*;

import org.apache.commons.io.IOUtils;

/**
 * Created by islabukhin on 30.09.16.
 */
public class TryWithResourceSample {

    public static void main(String[] args) {
        InputStream stream = IOUtils.toInputStream("Input stream" +
                " . Example of try with resources.");
        String result = "";
        try (BufferReaderWrapper bufferedReader = new BufferReaderWrapper(new InputStreamReader(stream))){
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine())!=null){
                resultBuilder.append(line);
            }
            result = resultBuilder.toString();
            System.out.println("Inside try. " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Outside try. " + result);
    }
}


class BufferReaderWrapper extends BufferedReader{

    public BufferReaderWrapper(Reader reader, int i) {
        super(reader, i);
    }

    public BufferReaderWrapper(Reader reader) {
        super(reader);
    }

    @Override
    public void close() throws IOException {
        super.close();
        System.out.println("BufferReaderWrapper is closed!");
    }
}