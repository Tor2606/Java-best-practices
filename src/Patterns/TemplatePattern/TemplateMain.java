package Patterns.TemplatePattern;

public class TemplateMain {
    public static void main(String[] args) {
        CSVDateParser csvDateParser = new CSVDateParser();
        csvDateParser.parseDataAndGenerateOutput();
        System.out.println("________________________");
        DatabaseParser databaseParser = new DatabaseParser();
        databaseParser.parseDataAndGenerateOutput();
    }
}
