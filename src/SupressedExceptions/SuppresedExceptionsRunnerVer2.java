package SupressedExceptions;

import static java.lang.System.err;

/**
 * Created by isla on 20.10.2016.
 */
public class SuppresedExceptionsRunnerVer2 {
    public static void main(String[] args) {
        try {
            performTryWithResource();
        } catch (Exception e) {
            err.println("Exception encountered: " + e.getMessage());
            final Throwable[] suppressedExceptions = e.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0) {
                err.println("\tThere are " + numSuppressed + " suppresed exceptions.");
                for (final Throwable exception : suppressedExceptions){
                    err.println("\t\t" + exception.toString());
                }
            }
        }
    }

    private static void performTryWithResource() throws Exception {
        try (NaughtyResource naughtyResource = new NaughtyResource()) {
            naughtyResource.doNothingGood();
        }
    }

}
