package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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
    private IViewController<VS> mViewController;

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

        mViewController.onViewCreated(savedInstanceState);
    }

    public abstract View getContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    public abstract void initContentView(View contentView);

    public abstract void observeViewState();

    protected void initViewController(Bundle savedInstanceState) {
        Class<? extends ViewModel> vsClass = ViewUtil.getTypeClass(this.getClass(), ViewState.class);
        mViewState = (VS) ViewModelProviders.of(this).get(vsClass);
        getLifecycle().addObserver(mViewState);

        mViewController = mViewState.getViewController();
        if (mViewController == null) {
            Class<VC> vcClass = ViewUtil.getTypeClass(this.getClass(), ViewController.class);
            try {
                mViewController = vcClass.newInstance();
                mViewController.setContext(getContext());
                mViewController.setLifecycleOwner(this);
                mViewController.setViewState(mViewState);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            mViewState.setViewController(mViewController);
        }
        mViewController.onCreate(getArguments(), savedInstanceState);
    }

    public VS getViewState() {
        return mViewState;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewController.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mViewController.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
