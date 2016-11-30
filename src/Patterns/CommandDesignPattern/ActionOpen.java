package Patterns.CommandDesignPattern;

//concrete command
public class ActionOpen implements ActionListenerCommand{

    private Document adoc;

    public ActionOpen(Document doc){
        this.adoc = doc;
    }

    @Override
    public void execute() {
        adoc.open();
    }
}
