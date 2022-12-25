package com.cyclone.sharememe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cyclone.sharememe.view.MemeActivity;

public class MainActivity extends AppCompatActivity {

    ImageView logoSplash;
    TextView tvSplash;

    Animation animate_logo, animate_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoSplash = findViewById(R.id.logoSplash);
        tvSplash = findViewById(R.id.tvSplash);

        animate_logo = AnimationUtils.loadAnimation(this, R.anim.animate_logo);
        animate_tv = AnimationUtils.loadAnimation(this, R.anim.animate_tv_splash);

        logoSplash.setAnimation(animate_logo);
        tvSplash.setAnimation(animate_tv);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MemeActivity.class);
                startActivity(intent);
            }
        },1000);

    }
}