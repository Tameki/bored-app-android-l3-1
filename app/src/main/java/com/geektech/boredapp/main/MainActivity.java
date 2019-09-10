package com.geektech.boredapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.geektech.boredapp.App;
import com.geektech.boredapp.R;
import com.geektech.boredapp.data.ActionRequestOptions;
import com.geektech.boredapp.data.IBoredApiClient;
import com.geektech.boredapp.model.BoredAction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.action_like_img)
    ImageView likeImg;

    @BindView(R.id.action_like_container)
    View likeImgContainer;

    private boolean isLiked = false;

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

        likeImgContainer.setOnClickListener(view -> {
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
            likeImg.startAnimation(anim);

            isLiked = !isLiked;
            if (isLiked) {
                likeImg.setImageResource(R.drawable.ic_heart_filled);
            } else {
                likeImg.setImageResource(R.drawable.ic_heart_empty);
            }
        });
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
        ActionRequestOptions requestOptions = new ActionRequestOptions(
                null,
                0.0f,
                1.0f,
                0f,
                1f,
                null
        );

        App.boredApiClient.getBoredAction(requestOptions, new IBoredApiClient.BoredActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                hideLoading();
                Log.d("ololo", "Response " + action.toString());
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
