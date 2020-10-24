package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    View action_home;
    View action_post;
    View action_user;
    RecyclerView rvPosts;
    List<Post> posts;
    PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        rvPosts = findViewById(R.id.rvPosts);
        posts = new ArrayList<>();
        adapter = new PostsAdapter(this, posts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);
        rvPosts.setAdapter(adapter);

        queryPost();

    }

    private void queryPost() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                adapter.clear();
                adapter.addAll(posts);
            }
        });
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