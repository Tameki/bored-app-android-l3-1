package com.geektech.boredapp.data;

import com.geektech.boredapp.model.BoredAction;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;

public class BoredApiClientTest {

    BoredApiClient boredApiClient;

    @Before
    public void setUp() {
        boredApiClient = new BoredApiClient();
    }

    @Test
    public void boredActionRequest() {
        //Prepare
        String key = "2211716";
        Call<BoredAction> call = boredApiClient.client.getBoredAction(
                key,
                null,
                null,
                null,
                null,
                null,
                null
        );

        try {
            //Interact
            Response<BoredAction> response = call.execute();
            BoredAction action = response.body();

            //Assert
            assertEquals(key, action.getKey());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void boredTypeActionRequest() {
        //Prepare
        String type = "education";
        Call<BoredAction> call = boredApiClient.client.getBoredAction(
                null,
                type,
                null,
                null,
                null,
                null,
                null
        );

        try {
            //Interact
            Response<BoredAction> response = call.execute();
            BoredAction action = response.body();

            //Assert
            assertEquals(type, action.getType().toString().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}