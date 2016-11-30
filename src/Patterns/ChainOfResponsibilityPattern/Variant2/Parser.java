package Patterns.ChainOfResponsibilityPattern.Variant2;

public class Parser {

    private Parser successor;

    public void parse(String fileName){
        if(getSuccessor() != null){
            getSuccessor().parse(fileName);
        }else{
            System.out.println("Unable to find the correct parser for the file: " + fileName);
        }
    }

    protected boolean canHandleFile(String fileName, String format){
        return (fileName == null)||(fileName.endsWith(format));
    }

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }

}
