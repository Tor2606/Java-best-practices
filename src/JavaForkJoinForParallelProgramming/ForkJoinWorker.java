package JavaForkJoinForParallelProgramming;

/**
 * Created by islabukhin on 09.09.16.
 */

import java.util.concurrent.ForkJoinPool;

import org.perf4j.StopWatch;
//worse results - paradox(May be some caching affords?)
public class ForkJoinWorker {

    public static void main(String[] args) {

        // Check the number of available processors
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("No of processors: " + processors);

        int n = 45;

        StopWatch stopWatch = new StopWatch();
        FibonacciProblem bigProblem = new FibonacciProblem(n);

        FibonacciTask task = new FibonacciTask(bigProblem);
        ForkJoinPool pool = new ForkJoinPool(processors);
        pool.invoke(task);

        long result = task.result;
        System.out.println("Computed Result: " + result);

        stopWatch.stop();
        System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());

    }

}
