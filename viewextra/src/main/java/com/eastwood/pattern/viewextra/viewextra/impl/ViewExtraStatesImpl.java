package com.eastwood.pattern.viewextra.viewextra.impl;

import com.eastwood.pattern.viewextra.activity.ActivityViewState;
import com.eastwood.pattern.viewextra.titlebar.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewextra.ViewExtraStates;

/**
 * @author eastwood
 * createDate: 2019-03-27
 */
public class ViewExtraStatesImpl implements ViewExtraStates {

    private TitleBarViewState mTitleBarViewState;
    private ActivityViewState mActivityViewState;

    @Override
    public TitleBarViewState getTitleBar() {
        if (mTitleBarViewState == null) {
            mTitleBarViewState = new TitleBarViewState();
        }
        return mTitleBarViewState;
    }

    @Override
    public ActivityViewState getActivity() {
        if (mActivityViewState == null) {
            mActivityViewState = new ActivityViewState();
        }
        return mActivityViewState;
    }

}
