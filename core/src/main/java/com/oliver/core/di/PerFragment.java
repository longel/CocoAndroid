package com.oliver.core.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   :
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerFragment {
}
