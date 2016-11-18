package CallableSamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FictionalEmailSenderRunner {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 30, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            List<Future<Boolean>> futures = new ArrayList<>(9000);
            for (int i = 1000; i < 10000; i++) {
                futures.add(executor.submit(new FictionalEmailSender(i +
                        "@some.com", "Knock, knock!", "You are in matrix")));
            }

            System.out.println("Starting shutdown...");
            executor.shutdown();

            while (!executor.isTerminated()) {
                executor.awaitTermination(1, TimeUnit.SECONDS);
                int progress = Math.round((executor.getCompletedTaskCount()*100) / executor.getTaskCount());
                System.out.println(progress + "% done ( " + executor.getCompletedTaskCount() + " emails have been sent).");
            }

            int errorCount = 0;
            int successCount = 0;
            for(Future<Boolean> future : futures){
                if(future.get()){
                    successCount++;
                }else{
                    errorCount++;
                }
            }

            System.out.println(successCount + " email were successfully sent, but "+ errorCount +" failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
