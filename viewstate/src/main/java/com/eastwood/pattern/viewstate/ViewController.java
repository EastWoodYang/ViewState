package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public abstract class ViewController<VS extends ViewState> implements IViewController<VS> {

    private LifecycleOwner mLifecycleOwner;

    private VS mViewState;

    @Override
    public VS getViewState() {
        return mViewState;
    }

    @Override
    public void setViewState(VS viewState) {
        this.mViewState = viewState;
    }

    @Override
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

}
