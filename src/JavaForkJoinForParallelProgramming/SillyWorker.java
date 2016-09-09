package JavaForkJoinForParallelProgramming;

import org.perf4j.StopWatch;

/**
 * Created by islabukhin on 09.09.16.
 */

public class SillyWorker {

    public static void main(String[] args) throws Exception {

        int n = 45;

        StopWatch stopWatch = new StopWatch();
        FibonacciProblem bigProblem = new FibonacciProblem(n);

        long result = bigProblem.solve();
        stopWatch.stop();

        System.out.println("Computing Fib number: " + n);
        System.out.println("Computed Result: " + result);
        System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());

    }

}