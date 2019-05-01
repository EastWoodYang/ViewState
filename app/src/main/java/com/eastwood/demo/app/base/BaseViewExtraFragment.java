package com.eastwood.demo.app.base;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.eastwood.demo.app.R;
import com.eastwood.pattern.viewextra.ViewExtraController;
import com.eastwood.pattern.viewextra.ViewExtraFragment;
import com.eastwood.pattern.viewextra.ViewExtraViewState;

import static android.view.View.NO_ID;

public abstract class BaseViewExtraFragment<VS extends ViewExtraViewState, VC extends ViewExtraController<VS>> extends ViewExtraFragment<VS, VC> {

    protected View mContentView;

    @Override
    public View getContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        mContentView = inflater.inflate(R.layout.layout_viewextra_container, container, false);
        FrameLayout contentContainer = mContentView.findViewById(R.id.content_container);
        inflater.inflate(getContentLayoutId(), contentContainer);
        return mContentView;
    }

    public abstract int getContentLayoutId();

    @Override
    public ViewGroup getTitleBarContainer() {
        return findViewById(R.id.title_bar_container);
    }

    public final <T extends View> T findViewById(@IdRes int id) {
        if (id == NO_ID || mContentView == null) {
            return null;
        }
        return mContentView.findViewById(id);
    }

    public final <T extends View> T findViewWithTag(Object tag) {
        if (tag == null || mContentView == null) {
            return null;
        }
        return mContentView.findViewWithTag(tag);
    }

    public boolean allowBackPressed() {
        return true;
    }

}
