package Patterns.StatePattern.StatePattern_v2;

public class TVContext implements State{

    public State getTvState() {
        return tvState;
    }

    public void setTvState(State tvState) {
        this.tvState = tvState;
    }

    private State tvState;

    @Override
    public void doAction() {
        tvState.doAction();
    }
}
