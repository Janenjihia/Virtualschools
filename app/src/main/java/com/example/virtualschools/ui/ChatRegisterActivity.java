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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatRegisterActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_username) MaterialEditText username;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_email) MaterialEditText email;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.chat_password) MaterialEditText password;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_register) Button register_btn;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.back_to_start) TextView back;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.go_log_in)  TextView log;

    FirebaseAuth auth;
    DatabaseReference reference;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_register);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();

        back.setOnClickListener(v -> startActivity(new Intent(ChatRegisterActivity.this, ChatActivity.class)));
        log.setOnClickListener(v -> startActivity(new Intent(ChatRegisterActivity.this, ChatLoginActivity.class)));


        register_btn.setOnClickListener(v -> {
            String txt_username= Objects.requireNonNull(username.getText()).toString();
            String txt_email= Objects.requireNonNull(email.getText()).toString();
            String txt_password= Objects.requireNonNull(password.getText()).toString();

            if(TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(this, "All Fields Are Required!", Toast.LENGTH_SHORT).show();
            } else {
                register(txt_username,txt_email,txt_password);
            }
        });
    }

    private void register(String username, String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        FirebaseUser firebaseUser = auth.getCurrentUser();
                        assert firebaseUser != null;
                        String userid = firebaseUser.getUid();
                        reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
                        HashMap<String, String> map = new HashMap<>();
                        map.put("id",userid);
                        map.put("username",username);
                        map.put("imageUrl", "default");
                        reference.setValue(map).addOnCompleteListener(task1 -> {
                            if (task1.isSuccessful()) {
                                Intent intent = new Intent(ChatRegisterActivity.this, MainChatActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        Toast.makeText(this, "You can't register with this email or password!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}