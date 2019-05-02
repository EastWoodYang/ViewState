package com.eastwood.pattern.viewextra.activity;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;

/**
 * @author eastwood
 * createDate: 2019-03-28
 */
public class ActivityViewState {

    private MutableLiveData<StartActivityInfo> startActivityData = new MutableLiveData<>();
    private MutableLiveData<Integer> resultCodeData = new MutableLiveData<>();
    private MutableLiveData<Intent> resultIntentData = new MutableLiveData<>();
    private MutableLiveData<Boolean> finishData = new MutableLiveData<>();

    void observeStartActivityInfoData(LifecycleOwner lifecycleOwner, Observer<StartActivityInfo> observer) {
        startActivityData.observe(lifecycleOwner, observer);
    }

    void observeResultCodeData(LifecycleOwner lifecycleOwner, Observer<Integer> observer) {
        resultCodeData.observe(lifecycleOwner, observer);
    }

    void observeResultIntentData(LifecycleOwner lifecycleOwner, Observer<Intent> observer) {
        resultIntentData.observe(lifecycleOwner, observer);
    }

    void observeFinishData(LifecycleOwner lifecycleOwner, Observer<Boolean> observer) {
        finishData.observe(lifecycleOwner, observer);
    }

    public void setResult(int resultCode) {
        setResult(resultCode, null);
    }

    public void setResult(int resultCode, Intent data) {
        resultCodeData.setValue(resultCode);
        if (data != null) {
            resultIntentData.setValue(data);
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        StartActivityInfo startActivityInfo = new StartActivityInfo();
        startActivityInfo.intent = intent;
        startActivityInfo.requestCode = requestCode;
        startActivityData.setValue(startActivityInfo);
    }

    public void finish() {
        finishData.setValue(true);
    }

}
