package com.geektech.boredapp;

import com.geektech.boredapp.utils.ISharedStorage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AppPreferencesTest {

    public AppPreferences appPreferences;

    @Mock
    ISharedStorage sharedStorage;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        appPreferences = new AppPreferences(sharedStorage);
    }

    @Test
    public void testFirstLaunchTrue() {
        //Prepare
        when(sharedStorage.get(AppPreferences.PREF_IS_FIRST_LAUNCH, true))
                .thenReturn(true);

        //Interact
        boolean isFirstLaunch = appPreferences.isFirstLaunch();

        //Assert
        assertTrue(isFirstLaunch);
    }

    @Test
    public void testFirstLaunchFalse() {
        //Prepare
        when(sharedStorage.get(AppPreferences.PREF_IS_FIRST_LAUNCH, true))
                .thenReturn(false);

        //Interact
        boolean isFirstLaunch = appPreferences.isFirstLaunch();

        //Assert
        assertFalse(isFirstLaunch);
    }

    @Test
    public void testSetLaunched() {
        //Interact
        appPreferences.setLaunched();

        //Assert
        verify(sharedStorage, atLeastOnce())
                .set(AppPreferences.PREF_IS_FIRST_LAUNCH, false);
    }

}