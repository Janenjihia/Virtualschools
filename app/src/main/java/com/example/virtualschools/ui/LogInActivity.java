package com.example.virtualschools.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.virtualschools.R;
import com.example.virtualschools.models.Login;
import com.example.virtualschools.models.Student;
import com.example.virtualschools.network.Api;
import com.example.virtualschools.network.Client;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.username) EditText username;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.password) EditText password;

    @SuppressLint("NonConstantResourceId")
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

        button.setOnClickListener(v -> login());

    }


    private static String studentToken;
    private void login(){
        ButterKnife.bind(this);
        String email=username.getText().toString();
        String pass=password.getText().toString();
        Login login = new Login(email,pass);
        Api client = Client.getClient();
        Call<Student> call = client.login(login);
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(@NonNull Call<Student> call, @NonNull Response<Student> response) {
                if (response.code()==200){
                    assert response.body() != null;
                    studentToken = response.body().getToken();
                    //save token
                    SharedPreferences preferences = getSharedPreferences("STUDENT_TOKEN", Context.MODE_PRIVATE);
                    preferences.edit().putString("TOKEN",studentToken).apply();
                    Intent intent = new Intent(LogInActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LogInActivity.this,"Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Student> call, @NonNull Throwable t) {
                Toast.makeText(LogInActivity.this, "Network Error, Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}