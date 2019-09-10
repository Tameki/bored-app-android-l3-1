package com.geektech.boredapp.data;

import android.util.Log;

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

    @Override
    public void getBoredAction(
            ActionRequestOptions requestOptions,
            final BoredActionCallback callback
    ) {
        Call<BoredAction> call = client.getBoredAction(
                requestOptions.getKey(),
                requestOptions.getType(),
                requestOptions.getMinPrice(),
                requestOptions.getMaxPrice(),
                requestOptions.getMinAccessibility(),
                requestOptions.getMaxAccessibility(),
                requestOptions.getParticipants()
        );

        Log.d("ololo", "Url " + call.request().url().toString());

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

    public interface BoredNetworkClient {
        @GET("api/activity/")
        Call<BoredAction> getBoredAction(
                @Query("key") String key,
                @Query("type") String type,
                @Query("minprice") Float minPrice,
                @Query("maxprice") Float maxPrice,
                @Query("minaccessibility") Float minAccessibility,
                @Query("maxaccessibility") Float maxAccessibility,
                @Query("participants") Integer participants
        );
    }
}
