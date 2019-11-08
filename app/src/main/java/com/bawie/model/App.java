package com.bawie.model;

import android.app.Application;
import android.content.Context;

/*
 *@Auther:刘阳
 *@Date: 2019年
 *@Time:
 *@Description:
 * */public class App extends Application {

     private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        this.context = context;
    }
}
