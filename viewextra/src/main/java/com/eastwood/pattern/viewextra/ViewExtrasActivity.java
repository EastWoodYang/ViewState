package com.eastwood.pattern.viewextra;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eastwood.pattern.viewextra.impl.ViewExtrasImpl;
import com.eastwood.pattern.viewstate.ViewActivity;

public abstract class ViewExtrasActivity<VS extends ViewExtrasState, VC extends ViewExtrasController<VS>>
        extends ViewActivity<VS, VC> implements ViewExtraContainers {

    private ViewExtras viewExtras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewExtras = new ViewExtrasImpl(getApplicationContext(), this, getViewState(), this);
    }

    public ViewExtras getViewExtras() {
        return viewExtras;
    }

}
