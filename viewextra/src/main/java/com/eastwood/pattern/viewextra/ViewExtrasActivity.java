package com.eastwood.pattern.viewextra;

import android.view.View;

import com.eastwood.pattern.viewextra.impl.ViewExtrasImpl;
import com.eastwood.pattern.viewstate.ViewActivity;

public abstract class ViewExtrasActivity<VS extends ViewExtrasViewState, VC extends ViewExtrasController<VS>>
        extends ViewActivity<VS, VC> implements ViewExtrasContainers {

    private IViewExtras viewExtras;

    @Override
    public void initContentView(View contentView) {
        viewExtras = new ViewExtrasImpl(getApplicationContext(), this, getViewState(), this);
    }

    public IViewExtras getViewExtras() {
        return viewExtras;
    }

}
