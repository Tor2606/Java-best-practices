package Patterns.TemplatePattern.MyTemplateSample;

public class AutmatedCleaning extends CleanTemplate {
    @Override
    public void cleanFromDust() {
        System.out.println("Cleaning from dust with vac. cleaner!");
    }

    @Override
    public void wetCleaning() {
        System.out.println("Automated wet cleaning with machine!");
    }

    @Override
    public void dryAfter() {
        System.out.println("Drying with machine!");
    }
}
