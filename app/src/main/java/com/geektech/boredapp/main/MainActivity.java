package com.geektech.boredapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.geektech.boredapp.App;
import com.geektech.boredapp.R;
import com.geektech.boredapp.data.IBoredApiClient;
import com.geektech.boredapp.model.BoredAction;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.refresh)
    void onClick(View view) {
        refreshAction();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        refreshAction();
    }

    //endregion

    //region Loading

    private void showLoading() {

    }

    private void hideLoading() {

    }

    private void showError() {

    }

    private void refreshAction() {
        showLoading();

        //TODO Fetch configs from View's

        App.boredApiClient.getBoredAction(new IBoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                hideLoading();
                Log.d("ololo", "Response " + action.getActivity() + " " +
                        action.getType());
            }

            @Override
            public void onFailure(Exception e) {
                showError();
                Log.d("ololo", "Failure " + e.getMessage());
            }
        });
    }

    //endregion
}
