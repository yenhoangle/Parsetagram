package com.example.yhle.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //register parse model
        ParseObject.registerSubclass(Post.class);
        //initialize parse
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qCDrisLc92trxBOG7hYZRk7f2tGMbOax1Aa5o3mn")
                .clientKey("Sbx14yE817HqBN80xN9IjawrDeCzW5ZyWUrbtIle")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
