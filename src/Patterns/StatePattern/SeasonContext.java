package Patterns.StatePattern;

public class SeasonContext {
    private Season season;

    public SeasonContext(){
        this.season = new Winter();
    }

    public void setSeason(Season season){
        this.season = season;
    }

    public void whatTheSeason(){
        season.theSeason(this);
    }
}
