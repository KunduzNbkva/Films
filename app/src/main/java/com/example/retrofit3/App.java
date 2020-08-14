package com.example.retrofit3;

import android.app.Application;

import com.example.retrofit3.data.GhibliService;

public class App extends Application {
    public static GhibliService ghibliService;
    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService=new GhibliService();
    }
}
