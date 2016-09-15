package VectorVsArrayListVsHashSet;

import org.perf4j.StopWatch;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by islabukhin on 15.09.16.
 */
public class InsertTest {
    public static void main(String[] args) throws InterruptedException {
        int iterations = 10;

        List syncList = Collections.synchronizedList(new ArrayList());
        Set syncSet = Collections.synchronizedSet(new HashSet());
        Vector vector = new Vector();

        ExecutorService executorService3 = Executors.newFixedThreadPool(50);
        StopWatch stopWatchVector = new StopWatch();
        stopWatchVector.start();
        executorService3.execute(() -> {
            for (int i = 0; i < iterations; i++) {
                vector.add("helloWorld-v" + i);
                if (i == iterations-1) stopWatchVector.stop();
            }
        });

        Thread.currentThread().sleep(1000L);

        ExecutorService executorService2 = Executors.newFixedThreadPool(50);
        StopWatch stopWatchSet = new StopWatch();
        stopWatchSet.start();
        executorService2.execute(() -> {
            for (int i = 0; i < iterations; i++) {
                syncSet.add("helloWorld-s" + i);
                if (i == iterations-1) stopWatchSet.stop();
            }
        });

        Thread.currentThread().sleep(1000L);

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        StopWatch stopWatchList = new StopWatch();
        stopWatchList.start();
        executorService.execute(() -> {
            for (int i = 0; i < iterations; i++) {
                syncList.add("helloWorld-l" + i);
                if (i == iterations-1) stopWatchList.stop();
            }
        });



        executorService.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();

        System.out.println("List:" + stopWatchList.getElapsedTime());
        System.out.println("Set:" + stopWatchSet.getElapsedTime());
        System.out.println("Vector" + stopWatchVector.getElapsedTime());
        syncList.stream().forEach(e -> System.out.println(e));
        syncSet.stream().forEach(e-> System.out.println(e));
        vector.stream().forEach(e-> System.out.println(e));
    }

}

//Insert - best are Vector and ArrayList;
