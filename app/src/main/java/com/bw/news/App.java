package com.bw.news;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

/**
 * @ClassName App
 * @Description TODO
 * @Author ZZQ
 * @Date 2021/8/21 11:26
 * @Version 1.0
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //依赖超过65536
        MultiDex.install(this);
    }
}
