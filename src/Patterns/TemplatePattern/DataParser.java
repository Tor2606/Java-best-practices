package Patterns.TemplatePattern;

//template abstract class defines some nontrivial complex operation(template method) as final
abstract public class DataParser {
    public final void parseDataAndGenerateOutput(){
        readData();
        processData();
        writeData();
    }
    abstract void readData();
    abstract void processData();

    public void writeData(){
        System.out.println("Output generated, writing to csv");
    }
}
