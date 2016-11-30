package GoogleGuava.StopWatch;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Math.random;

public class StopWatchSample {
    public static void main(String[] args) {
        final StopWatch stopWatch = new StopWatch();
        List<Integer> list = newArrayList();
        int num = 100000;
        IntStream.of(num).forEach(s -> list.add((int) (random()*10000)));
        stopWatch.start();
        Collections.sort(list);
        stopWatch.stop();
        System.out.println("QuickSort time for " + num + " Integer elem : " + stopWatch.getNanoTime() + " ns");
    }
}
