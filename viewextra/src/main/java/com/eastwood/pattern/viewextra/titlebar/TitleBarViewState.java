package com.eastwood.pattern.viewextra.titlebar;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

import com.eastwood.pattern.viewstate.SingleLiveEvent;

public class TitleBarViewState {

    private MutableLiveData<String> titleBarTitleState;
    private SingleLiveEvent<Boolean> titleBarArrowBackClickEvent;
    private SingleLiveEvent<Boolean> titleBarRightActionClickEvent;

    public void setTitleBarTitleState(String value) {
        if (titleBarTitleState == null) {
            titleBarTitleState = new MutableLiveData<>();
        }

        titleBarTitleState.setValue(value);
    }

    public void observeTitleBarTitleState(@NonNull LifecycleOwner owner, @NonNull Observer<String> observer) {
        if (titleBarTitleState == null) {
            titleBarTitleState = new MutableLiveData<>();
        }

        titleBarTitleState.observe(owner, observer);
    }

    public void setTitleBarBackArrowClickEvent(Boolean value) {
        if (titleBarArrowBackClickEvent == null) {
            titleBarArrowBackClickEvent = new SingleLiveEvent<>();
        }

        titleBarArrowBackClickEvent.setValue(value);
    }

    public void observeTitleBarBackArrowClickEvent(@NonNull LifecycleOwner owner, @NonNull Observer<Boolean> observer) {
        if (titleBarArrowBackClickEvent == null) {
            titleBarArrowBackClickEvent = new SingleLiveEvent<>();
        }

        titleBarArrowBackClickEvent.observe(owner, observer);
    }

    public void setTitleBarRightActionClickEvent(Boolean value) {
        if (titleBarRightActionClickEvent == null) {
            titleBarRightActionClickEvent = new SingleLiveEvent<>();
        }

        titleBarRightActionClickEvent.setValue(value);
    }

    public void observeTitleBarRightActionClickEvent(@NonNull LifecycleOwner owner, @NonNull Observer<Boolean> observer) {
        if (titleBarRightActionClickEvent == null) {
            titleBarRightActionClickEvent = new SingleLiveEvent<>();
        }

        titleBarRightActionClickEvent.observe(owner, observer);
    }


}
