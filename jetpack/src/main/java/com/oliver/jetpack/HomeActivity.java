package com.oliver.jetpack;

import android.view.View;

import com.oliver.core.activities.BaseActivity;

public class HomeActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void initializeDatas() {

    }

    @Override
    protected void initializeListeners() {
        findView(R.id.btn_LiveDataViewModel).setOnClickListener(this);
    }

    @Override
    protected void initializeViews() {

    }

    @Override
    protected int providerContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_LiveDataViewModel:
                startAct(LiveDataVMActivity.class);
                break;
        }
    }
}
