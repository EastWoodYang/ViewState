package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public class ViewFragment<VS extends ViewState, VC extends ViewController<VS>> extends Fragment {

    private VC mViewController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewController(savedInstanceState);
    }

    protected void initViewController(Bundle savedInstanceState) {
        Class<? extends ViewModel> vcClass = ViewUtil.getTypeClass(this, 1);
        mViewController = (VC) ViewModelProviders.of(this).get(vcClass);
        mViewController.setLifecycleOwner(this);
        getLifecycle().addObserver(mViewController);
        mViewController.onCreate(savedInstanceState);
    }

    public VS getViewState() {
        return mViewController.getViewState();
    }

}
