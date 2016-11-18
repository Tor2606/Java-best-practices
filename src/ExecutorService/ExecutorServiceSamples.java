package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSamples {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new ExecutedTestTask("First task"));
        executorService.execute(new ExecutedTestTask("Second task"));
        executorService.execute(new ExecutedTestTask("Third task"));

        executorService.shutdown();
    }
}
