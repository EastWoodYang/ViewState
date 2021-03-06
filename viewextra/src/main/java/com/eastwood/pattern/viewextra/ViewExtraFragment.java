package com.eastwood.pattern.viewextra;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;

import com.eastwood.pattern.viewextra.titlebar.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.viewextra.ViewExtraContainers;
import com.eastwood.pattern.viewextra.viewextra.ViewExtras;
import com.eastwood.pattern.viewextra.viewextra.impl.ViewExtrasImpl;
import com.eastwood.pattern.viewstate.ViewFragment;

public abstract class ViewExtraFragment<VS extends ViewExtraViewState, VC extends ViewExtraController<VS>>
        extends ViewFragment<VS, VC> implements ViewExtraContainers {

    private ViewExtras viewExtras;

    @Override
    public void initContentView(View contentView) {
        viewExtras = new ViewExtrasImpl(getActivity(), this, getViewState().getViewExtraStates(), this);
    }

    public ViewExtras getViewExtras() {
        return viewExtras;
    }

    @Override
    public void observeViewState() {
        getViewExtras().getActivity().createViewExtra();

        final ViewExtra<TitleBarViewState> titleBarViewExtra = getViewExtras().getTitleBar();
        titleBarViewExtra.getViewState().observeTitleBarBackArrowClickEvent(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (!titleBarViewExtra.isViewExtraCreated()) {
                    titleBarViewExtra.createViewExtra();
                }
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            }
        });

    }

}
