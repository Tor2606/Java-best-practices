package Patterns.ChainOfResponsibilityPattern.Variant2;

public class XmlParserLast extends Parser {

    @Override
    public void parse(String fileName) {
        if (canHandleFile(fileName, ".xml")) {
            System.out.println("A xml parser is handling the file: " + fileName);
        } else {
            super.parse(fileName);
        }
    }
}
