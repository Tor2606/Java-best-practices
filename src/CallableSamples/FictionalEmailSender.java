package CallableSamples;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FictionalEmailSender implements Callable<Boolean> {
    private String to;
    private String subject;
    private String body;

    public FictionalEmailSender(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(Math.round(Math.random() * TimeUnit.SECONDS.toMillis(1)));

        if (Math.random() > 0.2) {
            return true;
        }else{
            return false;
        }
    }
}
