package com.bw.news;

import android.app.Application;
import android.content.Context;

/**
 * @Name:yao
 * @CreateDate: 2021/8/20 14:30
 * @ProjectName: News
 * @Package: com.bw.news
 * @ClassName: MyApp
 */
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
