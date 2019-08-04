package com.example.intive_fdv.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intive_fdv.R;
import com.example.intive_fdv.ui.home.HomeActivity;
import com.example.intive_fdv.utils.TimeHandler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimeHandler timeHandler = new TimeHandler(1500, new TimeHandler.OnTimeComplete() {
            @Override
            public void onFinishTime() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        timeHandler.start();
    }
}
