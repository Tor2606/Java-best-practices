package ChainOfResponsibilityPattern;

public class ProcessorA extends Processor {

    public ProcessorA(int threshold) {
        this.threshold = threshold;
    }

    @Override
    protected void writeMessage(String data) {

    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing with A: " + data);
    }

}
