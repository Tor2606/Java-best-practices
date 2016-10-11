package Concurrency.ReentrantLocks;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLockFieldsClass {
    private int calculatedValue;
    private int value;
    private ReadWriteLock readWriteLock;

    public void calculate(int value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try {
            this.value = value;
            this.calculatedValue = doMySlowCalculation(value);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    private int doMySlowCalculation(int value) throws InterruptedException {
        Thread.currentThread().sleep(1000);
        return value * 2;
    }

    public synchronized int getCalculatedValue() {
        readWriteLock.readLock().lock();
        try{
            return calculatedValue;
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public synchronized int getValue() {
        readWriteLock.readLock().lock();
        try {
            return value;

        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
