package Concurrency.Semaphore;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamLimiterRunner {

    private static final String SERVICE_URL1 = "http://www.ipinfo.io/89.22.47.180/json";
    private static final String SERVICE_URL2 = "http://www.ipinfo.io/89.22.47.181/json";


    public static void main(String[] args) throws IOException, InterruptedException {
        InputStreamFromUrlLimiter inputStreamFromUrlLimiter = new InputStreamFromUrlLimiter(3);

        InputStream in1 = inputStreamFromUrlLimiter.acquire(SERVICE_URL1);
        InputStream in2 = inputStreamFromUrlLimiter.acquire(SERVICE_URL2);
        InputStream in3 = inputStreamFromUrlLimiter.acquire(SERVICE_URL1);
        System.out.println(IOUtils.toString(in2));
        inputStreamFromUrlLimiter.release(in3);
        inputStreamFromUrlLimiter.release(in2);
        inputStreamFromUrlLimiter.release(in1);
        System.out.println("finish");
    }
}
