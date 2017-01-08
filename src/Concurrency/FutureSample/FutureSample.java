package Concurrency.FutureSample;

import java.util.concurrent.*;

public class FutureSample {
    public static void main(String[] args) {
        Callable<String> callable1 = new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return Thread.currentThread().getName();
            }
        };

        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return Thread.currentThread().getName();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        FutureTask<String> task1 = new FutureTask<String>(callable1);
        FutureTask<String> task2 = new FutureTask<String>(callable2);

        executor.execute(task1);
        executor.execute(task2);

        while (true) {
            try {
                if (task1.isDone() && task2.isDone()){
                    System.out.println("Done");
                    executor.shutdown();
                    return;
                }

                if(!task1.isDone()){
                    System.out.println("Task1 output = " + task1.get());
                }
                System.out.println("Waiting for second task to complete");
                String s = task2.get(200l, TimeUnit.MILLISECONDS);
                if(s!=null){
                    System.out.println("Task2 output = " + s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
            }
        }
    }
}
