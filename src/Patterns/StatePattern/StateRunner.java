package Patterns.StatePattern;

public class StateRunner {
    public static void main(String[] args) {
        SeasonContext sc = new SeasonContext();
        sc.whatTheSeason();
        sc.whatTheSeason();
        sc.whatTheSeason();
        sc.whatTheSeason();
    }
}
