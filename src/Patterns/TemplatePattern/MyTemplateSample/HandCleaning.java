package Patterns.TemplatePattern.MyTemplateSample;

public class HandCleaning extends CleanTemplate {
    @Override
    public void cleanFromDust() {
        System.out.println("Cleaning dust with besom");
    }

    @Override
    public void wetCleaning() {
        System.out.println("Wet cleaning with mop");
    }

    @Override
    public void dryAfter() {
        System.out.println("Dry by itself");
    }
}
