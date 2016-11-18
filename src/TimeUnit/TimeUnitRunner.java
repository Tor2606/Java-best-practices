package TimeUnit;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeUnitRunner {
    public static void main(String[] args) throws InterruptedException {
        int time = 5*1000;//5ms
        long duration = TimeUnit.MILLISECONDS.convert(5,TimeUnit.SECONDS);
        long duration2 = TimeUnit.SECONDS.toMillis(5);
        System.out.println(new Date());
        TimeUnit.SECONDS.sleep(5);
        System.out.println(new Date());
    }
}
