package LambdasSamples;

/**
 * Created by islabukhin on 14.09.16.
 */
public class Sample1 {
    public static void main(String[] args) {

        // function has 4 things
        //name- anonymous in lambda
        //param list - lambda has
        //body - lambda has
        //return type - inferred(подразумевается) in lambda
        /*Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In another thread");
            }
        });*/
        // there is no anonymous classes in memory with lambdas!!(invoke dynamic)
        Thread th = new Thread(() ->
                System.out.println("In another thread"));

        th.start();

        System.out.println("In main");
    }
}
