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

    private ViewGroup mContainer;
    private NetErrorViewState viewState;

    private DefaultPageLayout defaultPageLayout;

    NetErrorImpl(Context context, LifecycleOwner lifecycleOwner, NetErrorViewState netErrorViewState, final ViewGroup container) {
        this.mContainer = container;
        viewState = netErrorViewState;

        defaultPageLayout = new DefaultPageLayout(context);
        // set default style...

        defaultPageLayout.setOnActionButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewState.netErrorRetryClickEvent.setValue(true);
            }
        });

        viewState.tipState.observe(lifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                defaultPageLayout.setTip(s);
            }
        });
        viewState.pictureResourceState.observe(lifecycleOwner, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer i) {
                defaultPageLayout.setPictureResource(i);
            }
        });
        viewState.actionButtonTextState.observe(lifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                defaultPageLayout.setActionButtonText(s);
            }
        });
        viewState.actionButtonVisibleState.observe(lifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean b) {
                defaultPageLayout.setActionButtonVisibility(b);
            }
        });
        viewState.netErrorViewVisibleState.observe(lifecycleOwner, new Observer<Boolean>() {
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
    public NetErrorViewState getViewState() {
        return viewState;
    }

}
