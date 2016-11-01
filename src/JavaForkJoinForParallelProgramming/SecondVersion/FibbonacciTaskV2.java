package JavaForkJoinForParallelProgramming.SecondVersion;

import java.util.concurrent.RecursiveTask;

public class FibbonacciTaskV2 extends RecursiveTask<Long> {
    private static final long serialVersionUID = 1L;

    private final long inputValue;

    public FibbonacciTaskV2(long inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    protected Long compute() {
        if (inputValue == 0L) {
            return 0L;
        } else if (inputValue <= 2L) {
            return 1L;
        } else {
            final FibbonacciTaskV2 firstWorker = new FibbonacciTaskV2(inputValue - 1L);
            firstWorker.fork();

            final FibbonacciTaskV2 secondWorker = new FibbonacciTaskV2(inputValue - 2L);
            return secondWorker.compute() + firstWorker.join();
        }
    }
}
