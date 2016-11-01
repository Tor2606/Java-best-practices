package SupressedExceptions;

/**
 * Created by isla on 20.10.2016.
 */
public class NaughtyResource implements AutoCloseable {

    public void doNothingGood(){
        throw new RuntimeException("Hahaha, nothing good");
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not suported operation yet");
    }
}
