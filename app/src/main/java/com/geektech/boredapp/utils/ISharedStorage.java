package com.geektech.boredapp.utils;

public interface ISharedStorage {

    <T> void set(String key, T value);

    <T> T get(String key, T defValue);

}
