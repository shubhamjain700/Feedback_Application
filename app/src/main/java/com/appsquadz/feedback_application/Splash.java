package com.appsquadz.feedback_application;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,SignActivity.class));

            }
        };
        handler.postDelayed(runnable,3000);

    }
}
