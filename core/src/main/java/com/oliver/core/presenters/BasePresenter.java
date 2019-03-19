package com.oliver.core.presenters;

import com.oliver.core.IBasePresenter;
import com.oliver.core.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   :
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    //弱引用，避免内存泄漏
    private Reference<V> mReference;
    // V 的动态代理，避免每次P层回调时判断V的存在
    private V mViewProxy;

    @Override
    public void attachView(V v) {
        mReference = new WeakReference<>(v);

        mViewProxy = (V) Proxy.newProxyInstance(v.getClass().getClassLoader(),
                v.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (isViewAlive()) {
                            return method.invoke(mReference.get(), args);
                        }
                        return null;
                    }
                });
    }

    private boolean isViewAlive() {
        return mReference != null && mReference.get() != null;
    }

    @Override
    public void detachView() {
        if (mReference != null) {
            mReference.clear();
        }
        mReference = null;
    }

    public V getView() {
        return mViewProxy;
    }

}
