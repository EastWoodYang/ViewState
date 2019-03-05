package com.eastwood.pattern.viewextra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.eastwood.pattern.viewextra.impl.ViewExtrasImpl;
import com.eastwood.pattern.viewstate.ViewActivity;

public abstract class ViewExtrasActivity<VS extends ViewExtrasState, VC extends ViewExtrasController<VS>>
        extends ViewActivity<VS, VC> implements ViewExtraContainers {

    private ViewExtras viewExtras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View contentView = LayoutInflater.from(this).inflate(getContentView(), null);
        setContentView(contentView);
        initContentView(contentView);

        // TODO
        viewExtras = new ViewExtrasImpl(getApplicationContext(), this, getViewState(), this);

        observerViewData();
    }

    public abstract int getContentView();

    public abstract void initContentView(View contentView);

    public abstract void observerViewData();

    public ViewExtras getViewExtras() {
        return viewExtras;
    }

}
