package com.example.virtualschools.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.virtualschools.R;
import com.example.virtualschools.models.StudentDetails;
import com.example.virtualschools.network.Api;
import com.example.virtualschools.network.Client;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.name) TextView studentName;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.role) TextView role;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.back) ImageView back;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.all_courses) TextView courses;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.all_bookmarks) TextView bookmarks;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.grades) TextView grades;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.attendance) TextView attendance;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.spinner) Spinner menu;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chatActionButton) ExtendedFloatingActionButton chat;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.edit_hold) FloatingActionButton edit;

    Boolean isChatVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        back.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this,MainActivity.class)));

        courses.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this,MainActivity.class)));

        bookmarks.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this,BookMarkActivity.class)));

        //spinner
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.profile_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        menu.setAdapter(adapter);

        //shrink action button

        isChatVisible=false;
        chat.shrink();

        chat.setOnClickListener(
                view -> {
                    if (!isChatVisible) {
                        chat.extend();
                        // make the boolean variable true
                        isChatVisible = true;
                    } else {
                        chat.shrink();
                        // make the boolean variable false
                        isChatVisible = false;
                        startActivity(new Intent(ProfileActivity.this,ChatActivity.class));
                    }
                }
        );

        //get profile details
        Api client = Client.getClient();
        //retrieve token
        SharedPreferences preferences = getSharedPreferences("STUDENT_TOKEN", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);

        Call<StudentDetails> call = client.getStudentDetails("Bearer "+retrivedToken);
        call.enqueue(new Callback<StudentDetails>() {
            @Override
            public void onResponse(@NonNull Call<StudentDetails> call, @NonNull Response<StudentDetails> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    studentName.setText(response.body().getName());
                    role.setText(response.body().getRole());
                } else {
                    Toast.makeText(ProfileActivity.this, "Bad Request", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<StudentDetails> call, @NonNull Throwable t) {
                Toast.makeText(ProfileActivity.this, "Network Failure", Toast.LENGTH_SHORT).show();
            }
        });

        //update profile details
        edit.setOnClickListener(v -> {
            Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
            edit.startAnimation(rotate);
            //Stop animation after 1 second
            new Handler().postDelayed(() -> edit.clearAnimation(), 1000);

        });

    }
}