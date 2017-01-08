package Patterns.StatePattern.StatePattern_v2;

public class TVRunner {
    public static void main(String[] args) {
        TVContext context = new TVContext();
        context.setTvState(new TVStopState());
        context.doAction();
        context.setTvState(new TVStartState());
        context.doAction();
    }
}
