package com.oliver.core.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.oliver.core.IBaseView;

import dagger.android.AndroidInjection;

/**
 * author : Oliver
 * date   : 2019/3/19
 * desc   :
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (supportFullScreen()) {
            getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        if (supportDagger()) {
            AndroidInjection.inject(this);
        }
        super.onCreate(savedInstanceState);
        setContentView(providerContentLayout());
        initializeViews();
        initializeListeners();
        initializeDatas();
    }

    protected boolean supportFullScreen() {
        return false;
    }

    protected abstract void initializeDatas();

    protected abstract void initializeListeners();

    protected abstract void initializeViews();

    public boolean supportDagger() {
        return false;
    }

    @LayoutRes
    protected abstract int providerContentLayout();

    public <V extends View> V findView(@IdRes int viewId) {
        return findViewById(viewId);
    }

    protected void startAct(@NonNull Class clazz) {
        startAct(clazz, false, null);
    }

    protected void startAct(@NonNull Class clazz, boolean finishCurrentAct) {
        startAct(clazz, finishCurrentAct, null);
    }

    protected void startAct(@NonNull Class clazz, boolean finishCurrentAct, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtra("ACTIVITY_BUNDLE", bundle);
        }
        startActivity(intent);
        if (finishCurrentAct) {
            finish();
        }
    }
}
