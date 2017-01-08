package Patterns.StrategyPatern;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class StrategyMain {
    public static void main(String[] args) {
        List<Strategy> strategies = newArrayList(
                () -> System.out.println("Performing task first strategy"),
                () -> System.out.println("Performing second strategy task"));
        strategies.forEach(Strategy::performTask);
    }
}
