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

import com.example.virtualschools.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.log_page) Button log_page;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.register_page) Button register_page;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_left) ImageView left;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_right) ImageView right;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.homeActionButton)
    ExtendedFloatingActionButton home;

    Boolean isHomeVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        //animation
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
        left.startAnimation(rotate);

        Animation antiRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anticlockwise);
        right.startAnimation(antiRotate);




        log_page.setOnClickListener(v -> startActivity(new Intent(ChatActivity.this,ChatLoginActivity.class)));
        register_page.setOnClickListener(v -> startActivity(new Intent(ChatActivity.this,ChatRegisterActivity.class)));

        //shrink action button

        isHomeVisible=false;
        home.shrink();

        home.setOnClickListener(
                view -> {
                    if (!isHomeVisible) {
                        home.extend();
                        // make the boolean variable true
                        isHomeVisible = true;
                    } else {
                        home.shrink();
                        // make the boolean variable false
                        isHomeVisible = false;
                        startActivity(new Intent(ChatActivity.this,MainActivity.class));
                    }
                }
        );
    }
}