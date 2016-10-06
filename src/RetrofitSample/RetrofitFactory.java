package RetrofitSample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static final String BASE_URL = "http://www.ipinfo.io";

    public RetrofitService getRetro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitService.class);
    }
}
