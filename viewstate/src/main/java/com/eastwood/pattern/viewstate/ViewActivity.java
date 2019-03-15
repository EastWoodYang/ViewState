package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public abstract class ViewActivity<VS extends ViewState, VC extends ViewController<VS>> extends AppCompatActivity {

    private VS mViewState;

    public VS getViewState() {
        return mViewState;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewState(savedInstanceState);

        View contentView = getContentView();
        setContentView(contentView);

        initContentView(contentView);

        observeViewState();

        ViewController viewController = (ViewController) getViewState().getViewController();
        viewController.onViewCreated(savedInstanceState);
    }

    protected void initViewState(Bundle savedInstanceState) {
        Class<? extends ViewModel> vsClass = ViewUtil.getTypeClass(this, 0);
        mViewState = (VS) ViewModelProviders.of(this).get(vsClass);
        getLifecycle().addObserver(mViewState);

        IViewController<VS> viewController = mViewState.getViewController();
        if (viewController == null) {
            Class<VC> vcClass = ViewUtil.getTypeClass(this, 1);
            try {
                viewController = vcClass.newInstance();
                viewController.setLifecycleOwner(this);
                viewController.setViewState(mViewState);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            mViewState.setViewController(viewController);
        }
        viewController.onCreate(savedInstanceState);
    }

    public abstract View getContentView();

    public abstract void initContentView(View contentView);

    public abstract void observeViewState();

}
