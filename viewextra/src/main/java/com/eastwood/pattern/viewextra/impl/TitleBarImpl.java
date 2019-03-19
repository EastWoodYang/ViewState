package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eastwood.pattern.viewextra.R;
import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;

// TODO
class TitleBarImpl implements ViewExtra<TitleBarViewState> {

    private Context mContext;
    private LifecycleOwner mLifecycleOwner;
    private ViewGroup mContainer;
    private TitleBarViewState mTitleBarViewState;

    private Toolbar mToolbar;

    TitleBarImpl(Context context, LifecycleOwner lifecycleOwner, TitleBarViewState titleBarViewState, final ViewGroup container) {
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mContainer = container;
        this.mTitleBarViewState = titleBarViewState;
    }

    @Override
    public void createViewExtra() {

        mToolbar = new Toolbar(mContext);

        TextView titleTextView = new TextView(mContext);
        titleTextView.setText("Title");
        titleTextView.setGravity(Gravity.CENTER);

        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        mToolbar.addView(titleTextView, layoutParams);

        int toolbarHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.toolbar_height);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, toolbarHeight);
        mContainer.addView(mToolbar, params);


    }

    @Override
    public boolean isViewExtraCreated() {
        return false;
    }

    @Override
    public TitleBarViewState getViewState() {
        return mTitleBarViewState;
    }

}
