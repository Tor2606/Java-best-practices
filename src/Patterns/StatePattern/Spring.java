package Patterns.StatePattern;

public class Spring implements Season {
    @Override
    public void theSeason(SeasonContext context) {
        System.out.println("The spring is now.");
        context.setSeason(new Winter());
    }
}
