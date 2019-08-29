package com.geektech.boredapp.data;

import com.geektech.boredapp.model.BoredAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BoredApiClient implements IBoredApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    BoredNetworkClient client = retrofit.create(BoredNetworkClient.class);

    @Override
    public void getBoredAction(final BoredActionCallback callback) {
        Call<BoredAction> call = client.getBoredAction();

        call.enqueue(new Callback<BoredAction>() {
            @Override
            public void onResponse(Call<BoredAction> call, Response<BoredAction> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onFailure(new Exception("Body is null"));
                    }
                } else {
                    callback.onFailure(new Exception("Response code " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<BoredAction> call, Throwable t) {
                callback.onFailure(new Exception(t));
            }
        });
    }

    private interface BoredNetworkClient {
        @GET("api/activity/")
        Call<BoredAction> getBoredAction();
    }
}
