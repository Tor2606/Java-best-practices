package Patterns.StatePattern;

public class Winter implements Season {
    @Override
    public void theSeason(SeasonContext context) {
        System.out.println("Winter is now.");
        context.setSeason(new Spring());
    }
}
