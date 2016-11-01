package SupressedExceptions;

import static java.lang.System.err;

/**
 * Created by isla on 20.10.2016.
 */
public class SuppresedExceptionsRunneer {
    public static void main(String[] args) {
        try {
            //performTryWithResource();
            //performTryFinally();
            performTryFinallyWithSuppresed();
        } catch (Exception e) {
            err.println("Exception encountered: " + e.getMessage());
            final Throwable[] suppressedExceptions = e.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0) {
                err.println("\tThere are " + numSuppressed + " suppresed exceptions.");
                for (final Throwable exception : suppressedExceptions) {
                    err.println("\t\t" + exception.toString());
                }
            }
        }
    }



    public static void performTryWithResource() throws Exception {
        try (NaughtyResource naughtyResource = new NaughtyResource()) {
            naughtyResource.doNothingGood();
        }
    }

    public static void performTryFinallyWithSuppresed() throws Exception{
        final NaughtyResource naughtyResource = new NaughtyResource();
        Throwable throwable = null;
        try{
            naughtyResource.doNothingGood();
        }catch (Exception usingEx){
            throwable = usingEx;
        }finally {
            try {
                naughtyResource.close();
            }catch (Exception closingExc){
                if(throwable != null){
                    closingExc.addSuppressed(throwable);
                    throw closingExc;
                }
            }
        }
    }

    public static void performTryFinally() throws Exception {
        final NaughtyResource naughtyResource =new NaughtyResource();
        try {
            naughtyResource.doNothingGood();
        }finally {
            naughtyResource.close();
        }
    }
}
