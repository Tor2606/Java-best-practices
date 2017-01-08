package Patterns.StatePattern.StatePattern_v2;

public class TVStopState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is turned Off!");
    }
}
