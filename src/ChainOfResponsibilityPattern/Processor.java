package ChainOfResponsibilityPattern;

public abstract class Processor {
    protected Processor next;
    protected int threshold;

    public void setNextProcessor(Processor p) {
        next = p;
    }

    public void process(String data, int value) {
        if (value <= threshold) {
            processData(data);
        }
        if (next != null) {
            next.writeMessage(data);
        }
    }

    protected abstract void writeMessage(String data);

    abstract protected void processData(String data);
}

