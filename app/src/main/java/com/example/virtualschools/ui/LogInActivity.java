package com.example.virtualschools.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.virtualschools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.username) EditText username;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.password) EditText password;

    @BindView(R.id.log_in_button)  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        username.setAlpha(0f);
        username.setTranslationY(50);
        username.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        password.setAlpha(0f);
        password.setTranslationY(50);
        password.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        button.setAlpha(0f);
        button.setTranslationY(50);
        button.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this,MainActivity.class);
            startActivity(intent);
        });

    }
}