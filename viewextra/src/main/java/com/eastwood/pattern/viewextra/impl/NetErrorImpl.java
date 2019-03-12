package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.views.DefaultPageLayout;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;

// TODO
class NetErrorImpl implements ViewExtra<NetErrorViewState> {

    private Context mContext;
    private LifecycleOwner mLifecycleOwner;
    private ViewGroup mContainer;
    private NetErrorViewState mNetErrorViewState;

    private DefaultPageLayout defaultPageLayout;

    NetErrorImpl(Context context, LifecycleOwner lifecycleOwner, NetErrorViewState netErrorViewState, final ViewGroup container) {
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mContainer = container;
        this.mNetErrorViewState = netErrorViewState;
    }

    @Override
    public void createViewExtra() {
        mContainer.addView(defaultPageLayout);
        // set default style...

        defaultPageLayout.setOnActionButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNetErrorViewState.netErrorRetryClickEvent.setValue(true);
            }
        });

        mNetErrorViewState.tipState.observe(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                defaultPageLayout.setTip(s);
            }
        });
        mNetErrorViewState.pictureResourceState.observe(mLifecycleOwner, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer i) {
                defaultPageLayout.setPictureResource(i);
            }
        });
        mNetErrorViewState.actionButtonTextState.observe(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                defaultPageLayout.setActionButtonText(s);
            }
        });
        mNetErrorViewState.actionButtonVisibleState.observe(mLifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean b) {
                defaultPageLayout.setActionButtonVisibility(b);
            }
        });

        mNetErrorViewState.netErrorViewVisibleState.observe(mLifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (defaultPageLayout == null) return;

                if (defaultPageLayout.getParent() == null) {
                    mContainer.addView(defaultPageLayout);
                }

                if (aBoolean == null || !aBoolean) {
                    defaultPageLayout.setVisibility(View.GONE);
                } else {
                    defaultPageLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean isViewExtraCreated() {
        return defaultPageLayout != null;
    }

    @Override
    public NetErrorViewState getViewState() {
        return mNetErrorViewState;
    }

}
