package com.geektech.boredapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorage implements ISharedStorage {
    SharedPreferences sharedPreferences;

    public SharedStorage(Context context, String prefsName) {
        sharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
    }

    @Override
    public void setBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }
}
