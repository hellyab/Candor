package com.blanco.apps.candor;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView affiliationTv;
    ImageView blancoSplashLogoIv;
    Animation fromBottom;
    Animation fromTop;
    ImageView candorSplashLogoIv;
    private static int SPLASH_TIME_OUT=5555;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candorSplashLogoIv = findViewById(R.id.candor_splash_logo_iv);
        blancoSplashLogoIv = findViewById(R.id.blanco_splash_logo_iv);
        affiliationTv = findViewById(R.id.affiliation_tv);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.from_top);
        blancoSplashLogoIv.setAnimation(fromBottom);
        affiliationTv.setAnimation(fromBottom);
        candorSplashLogoIv.setAnimation(fromTop);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent homeIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(homeIntent);
            }
        }, SPLASH_TIME_OUT);

    }
}
