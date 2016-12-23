package Patterns.TemplatePattern;

public class CSVDateParser extends DataParser {
    @Override
    void readData() {
        System.out.println("Reading data from csv");
    }

    @Override
    void processData() {
        System.out.println("Looping through loaded csv file");
    }
}
