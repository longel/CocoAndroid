package com.oliver.core;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   : P层，绑定View
 */

public interface IBasePresenter<V extends IBaseView> {

    // 实现IBaseView子类接口的Fragment或Activity
    void attachView(V v);

    void detachView();
}
