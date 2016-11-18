package NoClassDefFoundErrorSample;

public class NoClassDefFoundErrorSimulator {
    public static void main(String[] args) {
        System.out.println("java.lang.noClassDefFoundError Simulator - Training");

        try{
            System.out.println("First attempt to create a new instance of ClassA...\n");
            ClassA classA = new ClassA();
        }catch (Throwable any){
            any .printStackTrace();
        }

        try{
            System.out.println("Second attempt...\n");
            ClassA classA = new ClassA();
        }catch(Throwable any){
            any.printStackTrace();
        }

        try{
            System.out.println("Third attempt ...\n");

            ClassA classA = new ClassA();
        }catch (Throwable any){
            any.printStackTrace();
        }
        System.out.println("\n\n Finish");
    }
}
