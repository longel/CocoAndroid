package com.oliver.core.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   : Component想要依赖于一个带有 @Scope的Component，也得有一个Scope，但是已经不能用一个
 * 和“父Component”一样的Scope了，需要自定义一个
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
