package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.view.ViewGroup;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;

// TODO
class DataEmptyImpl implements ViewExtra<DataEmptyViewState> {

    private ViewGroup mContainer;
    private DataEmptyViewState viewState;

    DataEmptyImpl(Context context, LifecycleOwner lifecycleOwner, DataEmptyViewState dataEmptyViewState, final ViewGroup container) {
        this.mContainer = container;
        viewState = dataEmptyViewState;

    }

    @Override
    public void createViewExtra() {

    }

    @Override
    public boolean isViewExtraCreated() {
        return false;
    }

    @Override
    public DataEmptyViewState getViewState() {
        return viewState;
    }

}
