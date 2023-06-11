package com.example.a10120246uts;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;


import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {
    //(8 juni 2023, 10120246, Muhammad Naufal Malikulmulki, IF-06)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}