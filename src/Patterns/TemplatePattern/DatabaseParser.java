package Patterns.TemplatePattern;

public class DatabaseParser extends DataParser {
    @Override
    void readData() {
        System.out.println("Read from DB!");
    }

    @Override
    void processData() {
        System.out.println("Looping through db!");
    }
}
