package Concurrency.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDeathLockRunner {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sema1 = new Semaphore(1);
        Semaphore sema2 = new Semaphore(1);

        Thread thread1 = new Thread(new DoubleResourceGrabber(sema1, sema2));
        Thread thread2 = new Thread(new DoubleResourceGrabber(sema2, sema1));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Lucky");
    }

    private static class DoubleResourceGrabber implements Runnable {
        private Semaphore first;
        private Semaphore second;

        public DoubleResourceGrabber(Semaphore s1, Semaphore s2) {
            first = s1;
            second = s2;
        }

        public void run() {
            try {
                Thread t = Thread.currentThread();

                first.acquire();
                System.out.println(t + " acquired " + first);

                Thread.sleep(200); // demonstrate deadlock

                second.acquire();
                System.out.println(t + " acquired " + second);

                second.release();
                System.out.println(t + " released " + second);

                first.release();
                System.out.println(t + " released " + first);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
