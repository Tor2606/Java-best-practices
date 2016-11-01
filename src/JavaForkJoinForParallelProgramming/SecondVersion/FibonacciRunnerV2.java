package JavaForkJoinForParallelProgramming.SecondVersion;

import java.util.concurrent.ForkJoinPool;

public class FibonacciRunnerV2 {
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    private static final ForkJoinPool pool = new ForkJoinPool(AVAILABLE_PROCESSORS);

    public static void main(String[] args){
        int num = 2;
        FibbonacciTaskV2 fibonacciTask = new FibbonacciTaskV2(num);
        final long result = pool.invoke(fibonacciTask);
        System.out.println("Result("+ num + "): " + result);
    }
}
