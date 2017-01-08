package Patterns.StatePattern.StatePattern_v2;

public class TVStartState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is turned on!");
    }
}
