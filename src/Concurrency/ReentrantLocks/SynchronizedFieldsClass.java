package Concurrency.ReentrantLocks;

public class SynchronizedFieldsClass {
    private int calculatedValue;
    private int value;

    public synchronized void calculate(int value) throws InterruptedException {
        this.value = value;
        this.calculatedValue = doMySlowCalculation(value);
    }

    private int doMySlowCalculation(int value) throws InterruptedException {
        Thread.currentThread().sleep(1000);
        return value*2;
    }

    public synchronized int getCalculatedValue() {
        return calculatedValue;
    }

    public synchronized int getValue() {
        return value;
    }
}
