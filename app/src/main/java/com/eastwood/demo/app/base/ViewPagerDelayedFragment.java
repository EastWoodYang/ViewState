package com.eastwood.demo.app.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.eastwood.demo.app.R;
import com.eastwood.pattern.viewextra.ViewExtraViewState;
import com.eastwood.pattern.viewstate.ViewController;

/**
 * @author eastwood
 * createDate: 2019-03-21
 */
public abstract class ViewPagerDelayedFragment<VS extends ViewExtraViewState, VC extends ViewPagerDelayedController<VS>> extends BaseViewExtraFragment<VS, VC> {

    private ViewGroup contentView;
    private boolean mUserSeen = false;
    private boolean mViewCreated = false;

    private boolean mShowing;

    private Bundle savedInstanceState;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        contentView = (ViewGroup) inflater.inflate(R.layout.fragment_empty, container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViewCreated = true;
        tryViewCreatedFirstSight();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (!mUserSeen && isVisibleToUser) {
            mUserSeen = true;
            onUserFirstSight();
            tryViewCreatedFirstSight();
        }
        onUserVisibleChanged(isVisibleToUser);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewCreated = false;
        mUserSeen = false;
    }

    private void tryViewCreatedFirstSight() {
        if (mUserSeen && mViewCreated) {
            onViewCreatedFirstSight();
        }
    }

    /**
     * Called when the new created view is visible to user for the first time.
     */
    protected void onViewCreatedFirstSight() {
        if (mContentView == null) {
            getContentView(getLayoutInflater(), contentView);
            contentView.removeAllViews();
            contentView.addView(mContentView, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        initContentView(mContentView);

        observeViewState();

        ViewController viewController = (ViewController) getViewState().getViewController();
        viewController.onViewCreated(savedInstanceState);
    }

    /**
     * Called when the fragment's UI is visible to user for the first time.
     * <p>
     * <p>However, the view may not be created currently if in {@link android.support.v4.view.ViewPager}.
     */
    protected void onUserFirstSight() {

    }

    /**
     * Called when the visible state to user has been changed.
     */
    public void onUserVisibleChanged(boolean visible) {
        if (mViewCreated && mUserSeen) {
            if (visible) {
                onShow();
            } else {
                onHidden();
            }
        }
    }

    public void onShow() {
        mShowing = true;
        ViewPagerDelayedController viewController = (ViewPagerDelayedController) getViewState().getViewController();
        viewController.onShow();
    }

    public void onHidden() {
        mShowing = false;
        ViewPagerDelayedController viewController = (ViewPagerDelayedController) getViewState().getViewController();
        viewController.onHidden();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mViewCreated && mUserSeen && mShowing) {
            onShow();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mViewCreated && mUserSeen && !mShowing) {
            onHidden();
        }
    }

}
