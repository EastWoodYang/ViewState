package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public class ViewActivity<VS extends ViewState, VC extends ViewController<VS>> extends AppCompatActivity {

    private VS mViewState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewController(savedInstanceState);
    }

    protected void initViewController(Bundle savedInstanceState) {
        Class<? extends ViewModel> vsClass = ViewUtil.getTypeClass(this, 0);
        mViewState = (VS) ViewModelProviders.of(this).get(vsClass);
        getLifecycle().addObserver(mViewState);

        if (mViewState.getViewController() == null) {
            Class<VC> vcClass = ViewUtil.getTypeClass(this, 1);
            IViewController<VS> viewController = null;
            try {
                viewController = vcClass.newInstance();
                viewController.setLifecycleOwner(this);
                viewController.setViewState(mViewState);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mViewState.setViewController(viewController);
        }
        mViewState.getViewController().onCreate(savedInstanceState);
    }

    public VS getViewState() {
        return mViewState;
    }
}
