package com.geektech.boredapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.geektech.boredapp.R;
import com.geektech.boredapp.data.BoredApiClient;
import com.geektech.boredapp.data.IBoredApiClient;
import com.geektech.boredapp.model.BoredAction;

public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BoredApiClient().getBoredAction(new IBoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                Log.d("ololo", "Response " + action.getActivity());
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("ololo", "Failure " + e.getMessage());
            }
        });
    }
}
