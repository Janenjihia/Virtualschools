package com.example.virtualschools.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.virtualschools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.home) TextView home;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.bookmark) TextView book;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.profile) TextView profile;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.grid) GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        book.setOnClickListener(v -> {
            Intent intent =new Intent(MainActivity.this,BookMarkActivity.class);
            startActivity(intent);
        });

        home.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        });

//        grid.setOnClickListener(v -> {
//            FragmentTransaction transaction=getFragmentManager().beginTransaction();
//            transaction.replace(R.layout.activity_main, CoursesFragment.class);
//            transaction.addToBackStack(null);
//            transaction.commit();
//        });
    }
}