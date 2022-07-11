package com.example.virtualschools.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.virtualschools.R;
import com.google.firebase.auth.FirebaseAuth;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatLoginActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_email) MaterialEditText email;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_password) MaterialEditText password;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_log_in) Button log_btn;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.back_to_start) TextView back;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.go_register) TextView to_register;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_login);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();



        back.setOnClickListener(v -> startActivity(new Intent(ChatLoginActivity.this, ChatActivity.class)));
        to_register.setOnClickListener(v -> startActivity(new Intent(ChatLoginActivity.this, ChatRegisterActivity.class)));


        log_btn.setOnClickListener(v -> {
            String txt_email= Objects.requireNonNull(email.getText()).toString();
            String txt_password= Objects.requireNonNull(password.getText()).toString();

            if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(this, "All Fields Are Required!", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(txt_email,txt_password)
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(ChatLoginActivity.this, MainChatActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}