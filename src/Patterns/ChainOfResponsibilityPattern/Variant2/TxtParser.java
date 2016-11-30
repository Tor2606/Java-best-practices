package Patterns.ChainOfResponsibilityPattern.Variant2;

public class TxtParser extends Parser {
    public TxtParser(Parser successor) {
        setSuccessor(successor);
    }

    @Override
    public void parse(String fileName) {
        if (canHandleFile(fileName, ".txt")) {
            System.out.println("A text parser is handling the file: " + fileName);
        } else {
            super.parse(fileName);
        }
    }
}
