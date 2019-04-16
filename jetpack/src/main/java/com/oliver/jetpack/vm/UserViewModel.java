package com.oliver.jetpack.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Looper;

import com.oliver.jetpack.model.User;

/**
 * author : Oliver
 * date   : 2019/4/16
 * desc   :
 */

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> mMutableLiveData;

    public UserViewModel() {
        mMutableLiveData = new MutableLiveData<>();
        initUser();
    }

    public MutableLiveData<User> getUserMutableLiveData() {
        return mMutableLiveData;
    }

    private void initUser() {
        User user = new User();
        user.setName("Oliver");
        user.setAge(18);
        user.setLove("Coco");
        changeValue(user);
    }

    public void changeUser() {
        User user = new User();
        user.setName("Coco");
        user.setAge(18);
        user.setLove("Oliver");
        changeValue(user);
    }

    private void changeValue(User user) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            mMutableLiveData.setValue(user);
        } else {
            mMutableLiveData.postValue(user);
        }
    }
}
