package com.eastwood.demo.app;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.ViewExtrasActivity;
import com.eastwood.pattern.viewextra.ViewExtrasViewState;
import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;

public abstract class BizViewExtrasActivity<VS extends ViewExtrasViewState, VC extends BizViewExtrasController<VS>> extends ViewExtrasActivity<VS, VC> {

    @Override
    public View getContentView() {
        return LayoutInflater.from(this).inflate(getContentLayoutId(), null);
    }

    @Override
    public void observeViewState() {
        final ViewExtra<NetErrorViewState> netErrorViewExtra = getViewExtras().getNetError();
        netErrorViewExtra.getViewState().netErrorViewVisibleState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(!netErrorViewExtra.isViewExtraCreated()) {
                    netErrorViewExtra.createViewExtra();
                }
            }
        });

        final ViewExtra<DataEmptyViewState> dataEmptyViewExtra = getViewExtras().getDataEmpty();
        dataEmptyViewExtra.getViewState().dataEmptyViewVisibleState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(!dataEmptyViewExtra.isViewExtraCreated()) {
                    dataEmptyViewExtra.createViewExtra();
                }
            }
        });
    }

    public abstract int getContentLayoutId();

}
