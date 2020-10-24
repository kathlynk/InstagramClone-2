package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("PgPgN8HUwbqnAWtlDA6E1lJuIRXwimQbqfYIZBcM")
                .clientKey("0BZNBr3zeWlBUFMUR6qrRubSri3BGfau2aqTUjft")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
