package com.oliver.cocoandroid.di;

import android.app.Application;

import com.oliver.cocoandroid.CocoApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   :
 * <p>
 * AndroidInjector<T>:执行Android核心类【例如Activity或Fragment】的具体子类的依赖注入。泛型便是具体的子类型
 */

@Singleton // 保证在全局范围内单例
@Component(modules = {AndroidSupportInjectionModule.class})
public interface CocoComponent extends AndroidInjector<CocoApplication> {


    /**
     * Component的构建器。Component可以具有单个静态抽象类或者被 @Component.Builder 注解标注的接口。如果存在这两种类型的类，
     * 则类中的方法应该满足一下条件：
     * <pre>
     *     1、必须存在一个无参（抽象）方法，且返回当前Component。典型实例就是 Component build();
     *     2、Builder 及其父类的其他方法只能是单参数且返回void/自身【方法链式调用】的（抽象）方法
     *     3、每一个 Component依赖 必须有一个抽象的setter方法
     *     4、每一个 module依赖 假设没有可见的无参构造器，则必须存在一个抽象的setter方法。允许使用其他Dagger可以实例化的依赖项，但是不强求
     *     5、
     * </pre>
     */
    @Component.Builder
    interface Builder {

        /**
         * @BindsInstance 允许开发者传递一个实例。在Component的某个module的构造器需要该类型的参数时，便从这里提供
         * <p>
         * 1、参数没有被@Nullable标注，则不能为空
         * 2、此类方法必须在创建Component实力之前调用
         */
        @BindsInstance
        CocoComponent.Builder application(Application application);

        // 重写了 @Component.Builder，则这种返回Component类型且无参数的方法必须存在，且只能有一个
        CocoComponent build();
    }
}
