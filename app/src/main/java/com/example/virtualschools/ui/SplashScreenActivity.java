package com.example.virtualschools.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.virtualschools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.lightbulb) ImageView bulb;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.welcome_to) TextView welcome;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.e_learning) TextView logo;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.get_started_button) Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        bulb.setAnimation(topAnim);
        welcome.setAnimation(bottomAnim);
        logo.setAnimation(bottomAnim);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(SplashScreenActivity.this, LogInActivity.class);
            startActivity(intent);
        });
    }
}