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

    private MutableLiveData<StartActivityInfo> startActivityState = new MutableLiveData<>();
    private MutableLiveData<Integer> resultCodeState = new MutableLiveData<>();
    private MutableLiveData<Intent> resultDataState = new MutableLiveData<>();
    private MutableLiveData<Boolean> finishState = new MutableLiveData<>();

    void observeStartActivityInfoState(LifecycleOwner lifecycleOwner, Observer<StartActivityInfo> observer) {
        startActivityState.observe(lifecycleOwner, observer);
    }

    void observeResultCodeState(LifecycleOwner lifecycleOwner, Observer<Integer> observer) {
        resultCodeState.observe(lifecycleOwner, observer);
    }

    void observeResultDataState(LifecycleOwner lifecycleOwner, Observer<Intent> observer) {
        resultDataState.observe(lifecycleOwner, observer);
    }

    void observeFinishState(LifecycleOwner lifecycleOwner, Observer<Boolean> observer) {
        finishState.observe(lifecycleOwner, observer);
    }

    public void setResult(int resultCode) {
        setResult(resultCode, null);
    }

    public void setResult(int resultCode, Intent data) {
        resultCodeState.setValue(resultCode);
        if (data != null) {
            resultDataState.setValue(data);
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        StartActivityInfo startActivityInfo = new StartActivityInfo();
        startActivityInfo.intent = intent;
        startActivityInfo.requestCode = requestCode;
        startActivityState.setValue(startActivityInfo);
    }

    public void finish() {
        finishState.setValue(true);
    }

}
