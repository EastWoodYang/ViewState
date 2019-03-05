package com.eastwood.pattern.viewextra.viewstate;

import android.arch.lifecycle.MutableLiveData;

import com.eastwood.pattern.viewstate.SingleLiveEvent;

public class NetErrorViewState {

    public MutableLiveData<String> tipState = new MutableLiveData<>();
    public MutableLiveData<Integer> pictureResourceState = new MutableLiveData<>();
    public MutableLiveData<String> actionButtonTextState = new MutableLiveData<>();
    public MutableLiveData<Boolean> actionButtonVisibleState = new MutableLiveData<>();

    public MutableLiveData<Boolean> netErrorViewVisibleState = new MutableLiveData<>();

    public SingleLiveEvent<Boolean> netErrorRetryClickEvent = new SingleLiveEvent<>();

}
