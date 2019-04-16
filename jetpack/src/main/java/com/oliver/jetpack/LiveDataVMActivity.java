package com.oliver.jetpack;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.oliver.core.activities.BaseActivity;
import com.oliver.jetpack.model.User;
import com.oliver.jetpack.vm.UserViewModel;

public class LiveDataVMActivity extends BaseActivity {

    private TextView tvName;
    private TextView tvAge;
    private TextView tvLove;
    private TextView tvChange;
    private UserViewModel mUserViewModel;

    @Override
    protected void initializeDatas() {

    }

    @Override
    protected void initializeListeners() {
        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserViewModel.changeUser();
            }
        });
        mUserViewModel.getUserMutableLiveData().observe(this, new Observer<User>() {

            @Override
            public void onChanged(@Nullable User user) {
                Log.d("LiveDataVMActivity", "onChanged");
                if (user != null) {
                    tvName.setText(user.getName());
                    tvAge.setText(String.valueOf(user.getAge()));
                    tvLove.setText(user.getLove());
                }
            }
        });
    }

    @Override
    protected void initializeViews() {
        tvAge = findView(R.id.tv_age);
        tvName = findView(R.id.tv_name);
        tvLove = findView(R.id.tv_love);
        tvChange = findView(R.id.tv_change);
        mUserViewModel = new UserViewModel();
    }

    @Override
    protected int providerContentLayout() {
        return R.layout.activity_live_data_vm;
    }
}
