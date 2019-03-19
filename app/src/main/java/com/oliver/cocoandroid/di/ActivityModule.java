package com.oliver.cocoandroid.di;

import com.oliver.cocoandroid.MainActivity;
import com.oliver.core.di.PerActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   :
 */

@Module
public abstract class ActivityModule {

    @PerActivity
    // 该注解配合返回类型类中的AndroidInjector.inject(this)方法即可实现依赖注入
    // 为返回值类型生成一个 AndroidInjector，且这个Injector将实现 Subcomponent 并作为 该module所在的 Component 中作为一个子类
    // 注：这个注解必须用在一个抽象方法上，且该方法的返回值是一个具体的Android Framework 层类型，且不能带有参数
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}

