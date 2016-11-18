package ChainOfResponsibilityPattern;

public class Client {
    public static void main(String[] args) {
        Processor p, p1, p2;
        p1 = p = new ProcessorA(2);
        p2 = new ProcessorB(1);
        p1.setNextProcessor(p2);
        p.process("data1", 2);
        p.process("data2", 1);
    }
}
