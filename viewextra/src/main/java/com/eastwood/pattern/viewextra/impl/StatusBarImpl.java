package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.StatusBarViewState;

// TODO
class StatusBarImpl implements ViewExtra<StatusBarViewState> {

    private StatusBarViewState viewState;

    StatusBarImpl(Context context, LifecycleOwner lifecycleOwner, StatusBarViewState statusBarViewState) {
        viewState = statusBarViewState;

    }

    @Override
    public void createViewExtra() {

    }

    @Override
    public boolean isViewExtraCreated() {
        return false;
    }

    @Override
    public StatusBarViewState getViewState() {
        return viewState;
    }

}
