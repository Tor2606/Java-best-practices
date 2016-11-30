package Patterns.ChainOfResponsibilityPattern.Variant2;

public class JsonParser extends Parser {
    public JsonParser(Parser successor) {
        setSuccessor(successor);
    }

    @Override
    public void parse(String fileName) {
        if (canHandleFile(fileName, ".json")) {
            System.out.println("A json parser is handling the file: " + fileName);
        } else {
            super.parse(fileName);
        }
    }
}
