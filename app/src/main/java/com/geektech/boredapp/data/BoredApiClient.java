package com.geektech.boredapp.data;

import androidx.annotation.Nullable;

import com.geektech.boredapp.core.CoreApiClient;
import com.geektech.boredapp.core.ResponseHandler;
import com.geektech.boredapp.model.BoredAction;

import retrofit2.Call;
import retrofit2.http.GET;

public class BoredApiClient extends CoreApiClient
        implements IBoredApiClient {

    //TODO: Create getRetrofitClient(baseUrl, class) method in CoreApiClient
    BoredNetworkClient client = getRetrofit("http://www.boredapi.com/")
            .create(BoredNetworkClient.class);

    @Nullable
    private BoredAction lastAction;

    @Override
    public void getBoredAction(final BoredActionCallback callback) {
        if (lastAction == null) {
            Call<BoredAction> call = client.getBoredAction();
            call.enqueue(new ResponseHandler<BoredAction>() {
                @Override
                public void onSuccess(BoredAction result) {
                    lastAction = result;
                    callback.onSuccess(result);
                }

                @Override
                public void onFailure(Exception e) {
                    callback.onFailure(e);
                }
            });
        } else {
            callback.onSuccess(lastAction);
        }
    }

    private interface BoredNetworkClient {
        @GET("api/activity/")
        Call<BoredAction> getBoredAction();
    }
}
