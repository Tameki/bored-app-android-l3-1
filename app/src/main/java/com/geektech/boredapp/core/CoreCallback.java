package com.geektech.boredapp.core;

public interface CoreCallback<T> {
    void onSuccess(T action);

    void onFailure(Exception e);
}
