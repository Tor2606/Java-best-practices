package Concurrency.Semaphore;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Semaphore;

public class InputStreamFromUrlLimiter {
    private final Semaphore semaphore;

    public InputStreamFromUrlLimiter(int maxConcurrentResult) {
        semaphore = new Semaphore(maxConcurrentResult);
    }

    public InputStream acquire(String url) throws InterruptedException, IOException {
        semaphore.acquire();
        InputStream inputStream = new URL(url).openStream();
        return inputStream;
    }

    public void release(InputStream inputStream) {
        try {
            IOUtils.closeQuietly(inputStream);
        } finally {
            semaphore.release();
        }
    }
}
