package com.codepath.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("l8XiO3anBB3XTnsM0GaLYJKRUTUIMS0KFtgpvn0T")
                .clientKey("4twPfQSKpEprb7N6AzVWBe8r0DsLyRiICesYxfZO")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
