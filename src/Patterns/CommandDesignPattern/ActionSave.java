package Patterns.CommandDesignPattern;

public class ActionSave implements ActionListenerCommand {

    private Document adoc;

    public ActionSave(Document doc){
        this.adoc = doc;
    }
    @Override
    public void execute() {
        adoc.save();
    }
}
