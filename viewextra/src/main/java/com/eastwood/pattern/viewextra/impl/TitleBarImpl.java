package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.view.ViewGroup;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;

// TODO
class TitleBarImpl implements ViewExtra<TitleBarViewState> {

    private ViewGroup mContainer;
    private TitleBarViewState viewState;

    TitleBarImpl(Context context, LifecycleOwner lifecycleOwner, TitleBarViewState titleBarViewState, final ViewGroup container) {
        this.mContainer = container;
        viewState = titleBarViewState;

    }

    @Override
    public TitleBarViewState getViewState() {
        return viewState;
    }

}
