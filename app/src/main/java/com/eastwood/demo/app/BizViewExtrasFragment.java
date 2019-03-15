package com.eastwood.demo.app;

import android.arch.lifecycle.Observer;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.ViewExtrasFragment;
import com.eastwood.pattern.viewextra.ViewExtrasViewState;
import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;

import static android.view.View.NO_ID;

public abstract class BizViewExtrasFragment<VS extends ViewExtrasViewState, VC extends BizViewExtrasController<VS>> extends ViewExtrasFragment<VS, VC> {

    private View mContentView;

    @Override
    public View getContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mContentView = inflater.inflate(getContentLayoutId(), container, false);
        return mContentView;
    }

    @Override
    public void observeViewState() {
        final ViewExtra<NetErrorViewState> netErrorViewExtra = getViewExtras().getNetError();
        netErrorViewExtra.getViewState().netErrorViewVisibleState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (!netErrorViewExtra.isViewExtraCreated()) {
                    netErrorViewExtra.createViewExtra();
                }
            }
        });

        final ViewExtra<DataEmptyViewState> dataEmptyViewExtra = getViewExtras().getDataEmpty();
        dataEmptyViewExtra.getViewState().dataEmptyViewVisibleState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (!dataEmptyViewExtra.isViewExtraCreated()) {
                    dataEmptyViewExtra.createViewExtra();
                }
            }
        });
    }

    public abstract int getContentLayoutId();

    public final <T extends View> T findViewById(@IdRes int id) {
        if (id == NO_ID || mContentView == null) {
            return null;
        }
        return mContentView.findViewById(id);
    }

    public final <T extends View> T findViewWithTag(Object tag) {
        if (tag == null|| mContentView == null) {
            return null;
        }
        return mContentView.findViewWithTag(tag);
    }

}
