package com.example.a1200905_sondos_farrah;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView cloud1 = (ImageView) findViewById(R.id.cloud1);
        final ImageView sun = (ImageView) findViewById(R.id.sun);
        final ImageView cloud2 = (ImageView) findViewById(R.id.cloud2);
        final ImageView earth = (ImageView) findViewById(R.id.earth);
        final ImageView car = (ImageView) findViewById(R.id.car);
        final ImageView trafficLight = (ImageView) findViewById(R.id.trafficLight);
        final ImageView rock = (ImageView) findViewById(R.id.rock);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        animation.setRepeatMode(Animation.RESTART);
        animation.setAnimationListener(this);
        car.startAnimation(animation);


        sun.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotatesun));
        cloud1.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.transcloud1));
        cloud2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.transcloud2));


        AnimationDrawable traffic = (AnimationDrawable) trafficLight.getDrawable();
        traffic.setEnterFadeDuration(1000);
        traffic.setExitFadeDuration(1000);
        trafficLight.post(new Runnable(){

            @Override
            public void run() {
                traffic.start();
            }
        });




        Animation animationrock = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rockmov);
        rock.startAnimation(animationrock);





    }

    @Override
    public void onAnimationStart(Animation animation) {
        // Animation start logic
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Animation end logic
        animation.reset();
        animation.setDuration(8000);
        animation.start(); // Restart the animation

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // Animation repeat logic
    }
}