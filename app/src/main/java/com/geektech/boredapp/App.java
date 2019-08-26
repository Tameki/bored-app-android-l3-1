package com.geektech.boredapp;

import android.app.Application;
import android.util.Log;

import com.geektech.boredapp.utils.ISharedStorage;
import com.geektech.boredapp.utils.SharedStorage;

public class App extends Application {

    public static ISharedStorage sharedStorage;
    public static AppPreferences appPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("ololo", "OnCreate");
        sharedStorage = new SharedStorage(this, "prefs");
        appPreferences = new AppPreferences(sharedStorage);
    }
}
