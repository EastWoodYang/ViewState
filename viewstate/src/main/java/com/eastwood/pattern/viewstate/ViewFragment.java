package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public abstract class ViewFragment<VS extends ViewState, VC extends ViewController<VS>> extends Fragment {

    private VS mViewState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewController(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getContentView(inflater, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initContentView(view);

        observeViewState();

        ViewController viewController = (ViewController) getViewState().getViewController();
        viewController.onViewCreated(savedInstanceState);
    }

    public abstract View getContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    public abstract void initContentView(View contentView);

    public abstract void observeViewState();

    protected void initViewController(Bundle savedInstanceState) {
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

    public VS getViewState() {
        return mViewState;
    }

}
