package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.ToastViewState;

// TODO
class ToastImpl implements ViewExtra<ToastViewState> {

    private ToastViewState viewState;

    ToastImpl(Context context, LifecycleOwner lifecycleOwner, ToastViewState toastViewState) {
        viewState = toastViewState;

    }

    @Override
    public void createViewExtra() {

    }

    @Override
    public boolean isViewExtraCreated() {
        return false;
    }

    @Override
    public ToastViewState getViewState() {
        return viewState;
    }


}
