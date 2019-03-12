package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.DialogViewState;

// TODO
class DialogImpl implements ViewExtra<DialogViewState> {

    private DialogViewState viewState;

    DialogImpl(Context context, LifecycleOwner lifecycleOwner, DialogViewState dialogViewState) {
        viewState = dialogViewState;

    }

    @Override
    public void createViewExtra() {

    }

    @Override
    public boolean isViewExtraCreated() {
        return false;
    }

    @Override
    public DialogViewState getViewState() {
        return viewState;
    }

}
