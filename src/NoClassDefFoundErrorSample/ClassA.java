package NoClassDefFoundErrorSample;

public class ClassA {
    private final static String CLAZZ = ClassA.class.getName();
    //switch to cause NoClassDefFoundErrorSimulator
    private final static boolean REPLICATE_PROBLEM1 = true;
    private final static boolean REPLICATE_PROBLEM2 = false;

    private static String staticVar = initStaticVar();

    static {
        if (REPLICATE_PROBLEM2) throw new IllegalStateException("ClassA.static{}: Internal Error!");
    }

    public ClassA() {
        System.out.println("Creating a new instance of " + ClassA.class.getName() + "...");
    }

    private static String initStaticVar() {
        String stringData = "";
        if (REPLICATE_PROBLEM1) throw new IllegalStateException("ClassA.initStaticVar(): Internal Error");

        return stringData;
    }

}
