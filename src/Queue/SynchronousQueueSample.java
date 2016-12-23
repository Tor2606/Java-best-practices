package Queue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

import static com.google.common.collect.Lists.newArrayList;

//implementing Producer/Consumer using SynchronousQueue
public class SynchronousQueueSample {
    public final ExecutorService executor = Executors.newFixedThreadPool(2);
    final SynchronousQueue<String> queue = new SynchronousQueue<String>();

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        SynchronousQueueSample sample = new SynchronousQueueSample();

        Callable<Void> producer = sample.getProducer();
        Callable<Void> consumer = sample.getConsumer();

        List<Future<Void>> futures = sample.executor.invokeAll(newArrayList(producer, consumer));
        for (final Future<Void> future : futures) {
            future.get(7, TimeUnit.SECONDS);
        }
    }

    public Callable<Void> getProducer() {
        return new Callable<Void>() {
            private List<String> messages = newArrayList("First", "Second", "Third", "Last");
            final Iterator<String> iterator = messages.iterator();

            @Override
            public Void call() throws Exception {
                while (iterator.hasNext()) {
                    if (!queue.offer(iterator.next(), 3, TimeUnit.SECONDS)) {
                        System.out.println("Finished");
                    }
                }
                return null;
            }
        };
    }

    public Callable<Void> getConsumer() {
        return () -> {
            String message = "";
            while (message != null) {
                message = queue.poll(3, TimeUnit.SECONDS);
                if(message==null) {
                    System.out.println("Received empty message");
                    return null;
                }
                System.out.println(message);
                Thread.sleep(1000);
            }
            return null;
        };
    }
}
