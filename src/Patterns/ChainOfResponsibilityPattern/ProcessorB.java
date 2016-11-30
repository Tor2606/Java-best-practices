package Patterns.ChainOfResponsibilityPattern;

public class ProcessorB extends Processor {
    public ProcessorB(int threshold) {
        this.threshold = threshold;
    }

    protected void writeMessage(String data) {
        System.err.println("Processing with B: " + data);
    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing with A: " + data);
    }
}
