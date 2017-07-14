package com.example.menachi.fragmentdemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Aviv Gold on 6/11/2017.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        if(context!=null)
            Log.d("Tag","ag is the king");

    }


    public static Context getMyContext() {
        return context;
    }
}

