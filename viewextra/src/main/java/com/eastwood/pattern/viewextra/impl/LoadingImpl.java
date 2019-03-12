package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.view.ViewGroup;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.LoadingViewState;

// TODO
class LoadingImpl implements ViewExtra<LoadingViewState> {

    private ViewGroup mContainer;
    private LoadingViewState viewState;

    LoadingImpl(Context context, LifecycleOwner lifecycleOwner, LoadingViewState loadingViewState, final ViewGroup container) {
        this.mContainer = container;
        viewState = loadingViewState;

    }

    @Override
    public void createViewExtra() {

    }

    @Override
    public boolean isViewExtraCreated() {
        return false;
    }

    @Override
    public LoadingViewState getViewState() {
        return viewState;
    }

}
