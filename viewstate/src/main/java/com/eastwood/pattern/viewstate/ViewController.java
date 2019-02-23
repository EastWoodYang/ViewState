package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public class ViewController<VS extends ViewState> extends android.arch.lifecycle.ViewModel implements LifecycleObserver {

    private LifecycleOwner mLifecycleOwner;

    private VS mViewState;

    public ViewController() {
        try {
            Class vsClass = ViewUtil.getTypeClass(this, 0);
            mViewState = (VS) vsClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected VS getViewState() {
        return mViewState;
    }

    void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
    }

    protected LifecycleOwner getLifecycleOwner() {
        return mLifecycleOwner;
    }

    public void onCreate(Bundle savedInstanceState) {}


}
