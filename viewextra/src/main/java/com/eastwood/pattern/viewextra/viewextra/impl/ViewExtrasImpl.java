package com.eastwood.pattern.viewextra.viewextra.impl;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import com.eastwood.pattern.viewextra.activity.ActivityImpl;
import com.eastwood.pattern.viewextra.activity.ActivityViewState;
import com.eastwood.pattern.viewextra.titlebar.TitleBarImpl;
import com.eastwood.pattern.viewextra.titlebar.TitleBarViewExtra;
import com.eastwood.pattern.viewextra.titlebar.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewextra.ViewExtraContainers;
import com.eastwood.pattern.viewextra.viewextra.ViewExtraStates;
import com.eastwood.pattern.viewextra.viewextra.ViewExtras;

public class ViewExtrasImpl implements ViewExtras {

    private TitleBarViewExtra<TitleBarViewState> mTitleBarViewExtra;
    private ViewExtra<ActivityViewState> mActivityViewExtra;

    private Context mContext;
    private LifecycleOwner mLifecycleOwner;
    private ViewExtraStates mViewExtraStates;
    private ViewExtraContainers mViewExtraContainers;

    public ViewExtrasImpl(Context context, LifecycleOwner lifecycleOwner, ViewExtraStates viewExtraStates, ViewExtraContainers viewExtraContainers) {
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewExtraStates = viewExtraStates;
        this.mViewExtraContainers = viewExtraContainers;
    }

    @Override
    public ViewExtraStates getViewExtraStates() {
        return mViewExtraStates;
    }

    @Override
    public TitleBarViewExtra<TitleBarViewState> getTitleBar() {
        if (mTitleBarViewExtra == null) {
            mTitleBarViewExtra = new TitleBarImpl(mContext, mLifecycleOwner, mViewExtraStates.getTitleBar(), mViewExtraContainers.getTitleBarContainer());
        }
        return mTitleBarViewExtra;
    }

    @Override
    public ViewExtra<ActivityViewState> getActivity() {
        if (mActivityViewExtra == null) {
            mActivityViewExtra = new ActivityImpl((Activity) mContext, mLifecycleOwner, mViewExtraStates.getActivity());
        }
        return mActivityViewExtra;
    }

}
