package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.eastwood.pattern.viewextra.R;
import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.views.DefaultPageLayout;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;

class NetErrorImpl implements ViewExtra<NetErrorViewState> {

    private Context mContext;
    private LifecycleOwner mLifecycleOwner;
    private ViewGroup mContainer;
    private NetErrorViewState mNetErrorViewState;

    private DefaultPageLayout mDefaultPageLayout;

    NetErrorImpl(Context context, LifecycleOwner lifecycleOwner, NetErrorViewState netErrorViewState, final ViewGroup container) {
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mContainer = container;
        this.mNetErrorViewState = netErrorViewState;
    }

    @Override
    public void createViewExtra() {
        mDefaultPageLayout = new DefaultPageLayout(mContext);
        mDefaultPageLayout.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
        mDefaultPageLayout.setPictureResource(R.drawable.ic_network_fail);
        mDefaultPageLayout.setTip("网络加载失败，请重试");
        mDefaultPageLayout.setActionButtonText("重新加载");
        mDefaultPageLayout.setActionButtonVisibility(true);
        mDefaultPageLayout.setOnActionButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDefaultPageLayout.setVisibility(View.GONE);
                mNetErrorViewState.netErrorRetryClickEvent.setValue(true);
            }
        });

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContainer.addView(mDefaultPageLayout, params);

        mDefaultPageLayout.setVisibility(View.GONE);

        mNetErrorViewState.tipState.observe(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mDefaultPageLayout.setTip(s);
            }
        });
        mNetErrorViewState.pictureResourceState.observe(mLifecycleOwner, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer i) {
                mDefaultPageLayout.setPictureResource(i);
            }
        });
        mNetErrorViewState.actionButtonTextState.observe(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mDefaultPageLayout.setActionButtonText(s);
            }
        });
        mNetErrorViewState.actionButtonVisibleState.observe(mLifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean b) {
                mDefaultPageLayout.setActionButtonVisibility(b);
            }
        });

        mNetErrorViewState.netErrorViewVisibleState.observe(mLifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (mDefaultPageLayout == null) return;

                if (mDefaultPageLayout.getParent() == null) {
                    mContainer.addView(mDefaultPageLayout);
                }

                if (aBoolean == null || !aBoolean) {
                    mDefaultPageLayout.setVisibility(View.GONE);
                } else {
                    mDefaultPageLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean isViewExtraCreated() {
        return mDefaultPageLayout != null;
    }

    @Override
    public NetErrorViewState getViewState() {
        return mNetErrorViewState;
    }

}
