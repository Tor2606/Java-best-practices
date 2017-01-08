package Patterns.Memento;

public class MementoRunner {
    public static void main(String[] args) {
        FileWriterCaretaker caretaker = new FileWriterCaretaker();
        FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
        fileWriter.write("First writing data\n");
        System.out.println(fileWriter + "\n\n");

        caretaker.save(fileWriter);
        fileWriter.write("Second writing data\n");

        System.out.println(fileWriter + "\n\n");

        caretaker.undo(fileWriter);

        System.out.println(fileWriter + "\n\n");
    }
}
