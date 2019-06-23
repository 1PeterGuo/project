package com.example.guolei.myapplication.base;

import android.app.Application;
import android.content.Context;

/**
 * Created on 2019/6/18 15:32
 *
 * @author Q.PeterGuo
 * @version 1.0.0
 * @Description
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    // 解决第三方依赖出错
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
