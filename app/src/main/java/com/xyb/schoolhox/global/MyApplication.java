package com.xyb.schoolhox.global;

import android.app.Application;
import android.content.Context;

/**
 * Created by 陈鑫权  on 2019/3/20.
 */

public class MyApplication extends Application {
    public static Context mCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        mCtx = this;


    }
}
