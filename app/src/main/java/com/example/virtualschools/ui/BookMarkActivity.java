package com.example.virtualschools.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.virtualschools.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookMarkActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.home_) TextView home;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.bookmark_) TextView book;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.profile_) TextView profile;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.grid) GridLayout grid;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chatActionButton)
    ExtendedFloatingActionButton chat;

    Boolean isChatVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark_layout);
        ButterKnife.bind(this);

        book.setOnClickListener(v -> {
            Intent intent =new Intent(BookMarkActivity.this,BookMarkActivity.class);
            startActivity(intent);
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(BookMarkActivity.this,MainActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(BookMarkActivity.this,ProfileActivity.class);
            startActivity(intent);
        });

//        grid.setOnClickListener(v -> {
//            FragmentTransaction transaction=getFragmentManager().beginTransaction();
//            transaction.replace(R.layout.bookmark_layout, CoursesFragment.class);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        });

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
                        startActivity(new Intent(BookMarkActivity.this,ChatActivity.class));
                    }
                }
        );
    }
}