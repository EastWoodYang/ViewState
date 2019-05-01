package com.eastwood.demo.app.base;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.eastwood.demo.app.R;
import com.eastwood.pattern.viewextra.ViewExtraActivity;
import com.eastwood.pattern.viewextra.ViewExtraViewState;

import java.util.List;

public abstract class BaseViewExtraActivity<VS extends ViewExtraViewState, VC extends BaseViewExtraController<VS>> extends ViewExtraActivity<VS, VC> {

    @Override
    public View getContentView() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View viewExtraContainer = layoutInflater.inflate(R.layout.layout_viewextra_container, null);
        FrameLayout contentContainer = viewExtraContainer.findViewById(R.id.content_container);
        layoutInflater.inflate(getContentLayoutId(), contentContainer);
        return viewExtraContainer;
    }

    public abstract int getContentLayoutId();

    @Override
    public ViewGroup getTitleBarContainer() {
        return findViewById(R.id.title_bar_container);
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        for (int i = 0; i < fragmentList.size(); i++) {
            Fragment fragment = fragmentList.get(i);
            if (fragment.isVisible() && fragment instanceof BaseViewExtraFragment) {
                BaseViewExtraFragment bizViewExtraFragment = (BaseViewExtraFragment) fragment;
                if (!bizViewExtraFragment.allowBackPressed()) {
                    return;
                }
            }
        }

        if (allowBackPressed()) {
            super.onBackPressed();
        }
    }

    public boolean allowBackPressed() {
        return true;
    }

}
