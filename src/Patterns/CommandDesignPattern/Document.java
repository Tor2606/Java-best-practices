package Patterns.CommandDesignPattern;


//Receiver
public class Document {
    public void open(){
        System.out.println("Document opened");
    }

    public void save(){
        System.out.println("Document saved");
    }
}
