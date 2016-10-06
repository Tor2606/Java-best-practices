package RetrofitSample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitAsyncSample {

    public static void main(String[] args) {
        new Thread(() -> {

            String ipAdress = "89.22.47.180";
            RetrofitFactory retrofitFactory = new RetrofitFactory();

            Call<InfoDto> call = retrofitFactory.getRetro().getRecommendationItems(ipAdress);
            call.enqueue(new Callback<InfoDto>() {
                @Override
                public void onFailure(Call<InfoDto> call, Throwable throwable) {
                    System.out.println("fail");
                }

                @Override
                public void onResponse(Call<InfoDto> call, Response<InfoDto> response) {
                    InfoDto infoDto = response.body();
                    System.out.println(infoDto.getCountry());
                    System.out.println(infoDto.getHostname());
                }

            });


        }).run();
    }
}
