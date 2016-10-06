package RetrofitSample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("{ip}/json")
    Call<InfoDto> getRecommendationItems(@Path("ip") String ipAddress);

}
