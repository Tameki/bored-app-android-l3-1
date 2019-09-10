package com.geektech.boredapp;

import com.geektech.boredapp.utils.ISharedStorage;

public class AppPreferences {

    public static final String PREF_IS_FIRST_LAUNCH = "is_first_launch";
    private static final String PREF_IS_LIGHT_MODE = "is_light_mode";

    private ISharedStorage sharedStorage;

    public AppPreferences(ISharedStorage sharedStorage) {
        this.sharedStorage = sharedStorage;
    }

    boolean isFirstLaunch() {
        return sharedStorage.get(PREF_IS_FIRST_LAUNCH, true);
    }

    void setLaunched() {
        sharedStorage.set(PREF_IS_FIRST_LAUNCH, false);
    }
}
