package com.oliver.cocoandroid;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   :
 */

public class CocoApplication extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    // 其实就是返回一个自定义的Component，提供Application实例
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
