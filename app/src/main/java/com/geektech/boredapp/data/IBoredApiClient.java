package com.geektech.boredapp.data;

import com.geektech.boredapp.model.BoredAction;

public interface IBoredApiClient {

    void getBoredAction(BoredActionCallback callback);

    interface BoredActionCallback {
        void onSuccess(BoredAction action);

        void onFailure(Exception e);
    }
}
