package com.geektech.boredapp.data;

import com.geektech.boredapp.core.CoreApiClient;
import com.geektech.boredapp.core.ResponseHandler;
import com.geektech.boredapp.model.BoredAction;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class BoredApiClient extends CoreApiClient
        implements IBoredApiClient {

    //TODO: Create getRetrofitClient(baseUrl, class) method in CoreApiClient
    BoredNetworkClient client = getRetrofit("http://www.boredapi.com/")
            .create(BoredNetworkClient.class);

    //TODO: Pass type, minPrice, maxPrice, minAccessibility, maxAccessibility
    @Override
    public void getBoredAction(final BoredActionCallback callback) {
        Call<BoredAction> call = client.getBoredAction("");

        call.enqueue(new ResponseHandler<BoredAction>() {
            @Override
            public void onSuccess(BoredAction result) {
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }

    private interface BoredNetworkClient {
        @GET("api/activity/")
        Call<BoredAction> getBoredAction(
                @Query("key") String value //TODO: Pass type
        );
    }
}
