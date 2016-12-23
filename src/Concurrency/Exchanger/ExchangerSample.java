package Concurrency.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerSample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(()->{
            System.out.println("Inside first executor");
            String message = "Message first";
            try {
                System.out.println("1. Message received: " + exchanger.exchange(message));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()->{
            System.out.println("Inside second executor");
            String message = "Message second";
            try {
                System.out.println("2. Message received: " + exchanger.exchange(message));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
