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
import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;

// TODO
class DataEmptyImpl implements ViewExtra<DataEmptyViewState> {

    private Context mContext;
    private LifecycleOwner mLifecycleOwner;
    private ViewGroup mContainer;
    private DataEmptyViewState mDataEmptyViewState;

    private DefaultPageLayout mDefaultPageLayout;

    DataEmptyImpl(Context context, LifecycleOwner lifecycleOwner, DataEmptyViewState dataEmptyViewState, final ViewGroup container) {
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mContainer = container;
        this.mDataEmptyViewState = dataEmptyViewState;
    }

    @Override
    public void createViewExtra() {
        mDefaultPageLayout = new DefaultPageLayout(mContext);
        mDefaultPageLayout.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
        mDefaultPageLayout.setPictureResource(R.drawable.ic_data_empty);
        mDefaultPageLayout.setTip("无内容展示");
        mDefaultPageLayout.setActionButtonText("重新加载");
        mDefaultPageLayout.setActionButtonVisibility(true);
        mDefaultPageLayout.setOnActionButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDefaultPageLayout.setVisibility(View.GONE);
                mDataEmptyViewState.dataEmptyRetryClickEvent.setValue(true);
            }
        });

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContainer.addView(mDefaultPageLayout, params);

        mDefaultPageLayout.setVisibility(View.GONE);

        mDataEmptyViewState.tipState.observe(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mDefaultPageLayout.setTip(s);
            }
        });
        mDataEmptyViewState.pictureResourceState.observe(mLifecycleOwner, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer i) {
                mDefaultPageLayout.setPictureResource(i);
            }
        });
        mDataEmptyViewState.actionButtonTextState.observe(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mDefaultPageLayout.setActionButtonText(s);
            }
        });
        mDataEmptyViewState.actionButtonVisibleState.observe(mLifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean b) {
                mDefaultPageLayout.setActionButtonVisibility(b);
            }
        });

        mDataEmptyViewState.dataEmptyViewVisibleState.observe(mLifecycleOwner, new Observer<Boolean>() {
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
    public DataEmptyViewState getViewState() {
        return mDataEmptyViewState;
    }

}
