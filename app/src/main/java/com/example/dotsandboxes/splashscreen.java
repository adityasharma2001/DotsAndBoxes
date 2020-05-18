package com.example.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        ImageView imageView=findViewById(R.id.imageView);
        Animation splash_anim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        imageView.startAnimation(splash_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splashscreen.this, MainActivity.class);
                startActivity(intent);
                //To disable default transition between layouts
                overridePendingTransition(0,0);
                finish();

            }
        }, 5000);
    }
}
