package com.geektech.boredapp.data;

import com.geektech.boredapp.core.CoreCallback;
import com.geektech.boredapp.model.BoredAction;

public interface IBoredApiClient {

    void getBoredAction(
            ActionRequestOptions requestOptions,
            BoredActionCallback callback
    );

    interface BoredActionCallback extends CoreCallback<BoredAction> {}
}
