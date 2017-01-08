package Patterns.TemplatePattern.MyTemplateSample;

public abstract class CleanTemplate {
    public final void clean() {
        cleanFromDust();
        wetCleaning();
        dryAfter();
    }

    public abstract void cleanFromDust();

    public abstract void wetCleaning();

    public abstract void dryAfter();

}
