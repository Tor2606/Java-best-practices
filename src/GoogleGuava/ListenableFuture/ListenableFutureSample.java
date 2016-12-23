package GoogleGuava.ListenableFuture;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

public class ListenableFutureSample {
    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));
        SynchronousQueue<String> buffer = new SynchronousQueue<String>();
        final ListenableFuture<String> future1 = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                boolean offer = buffer.offer("Message", 2, TimeUnit.SECONDS);
                System.out.println("Put into queue: " + offer);
                return String.valueOf(offer);
            }
        });

        final ListenableFuture<String> future2 = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String message = buffer.poll(2, TimeUnit.SECONDS);
                System.out.println("Poll from queue. Message: " + message);
                return message;
            }
        });

        /*future1.addListener(new Runnable() {
            @Override
            public void run() {
                try{
                    final String content = future1.get();
                    System.out.println("Future1: " + content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, MoreExecutors.sameThreadExecutor());
        future2.addListener(new Runnable() {
            @Override
            public void run() {
                try{
                    final String content = future2.get();
                    System.out.println("Future 2:" + content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }, MoreExecutors.sameThreadExecutor());*/

        Futures.addCallback(future1, new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("Future1: " + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });

        Futures.addCallback(future2, new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                System.out.println("Future2: " + s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }

}
