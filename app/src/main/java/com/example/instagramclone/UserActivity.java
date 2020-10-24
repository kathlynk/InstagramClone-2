package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class UserActivity extends AppCompatActivity {

    public static final String TAG = "UserActivity";
    private View action_home;
    private View action_post;
    private View action_user;
    private Button btnLogout;
    private ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        action_home = findViewById(R.id.action_home);
        action_post = findViewById(R.id.action_post);
        action_user = findViewById(R.id.action_user);

        action_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick home button");
                goMainActivity();
            }
        });
        action_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick post button");
                goPostActivity();
            }
        });

        action_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick user button");
                goUserActivity();
            }
        });

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                goLoginActivity();
            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goPostActivity() {
        Intent i = new Intent(this, PostActivity.class);
        startActivity(i);
    }

    private void goUserActivity() {
        Intent i = new Intent(this, UserActivity.class);
        startActivity(i);
        finish();
    }
}