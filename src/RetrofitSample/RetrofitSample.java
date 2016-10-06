package RetrofitSample;

import java.io.IOException;

public class RetrofitSample {
    public static void main(String[] args) {
        new Thread(()->{String ipAdress = "89.22.47.180";
            RetrofitFactory retrofitFactory = new RetrofitFactory();
            InfoDto infoDto = null;
            try {
                infoDto = retrofitFactory.getRetro().getRecommendationItems(ipAdress)
                        .execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(infoDto.getCountry());
            System.out.println(infoDto.getHostname());}).run();

    }
}
