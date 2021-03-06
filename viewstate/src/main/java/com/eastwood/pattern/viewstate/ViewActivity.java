package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public abstract class ViewActivity<VS extends ViewState, VC extends ViewController<VS>> extends AppCompatActivity {

    private VS mViewState;
    private IViewController<VS> mViewController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewState(savedInstanceState);

        View contentView = getContentView();
        setContentView(contentView);

        initContentView(contentView);

        observeViewState();

        mViewController.onViewCreated(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mViewController.onNewIntent(intent);
    }

    protected void initViewState(Bundle savedInstanceState) {
        Class<? extends ViewModel> vsClass = ViewUtil.getTypeClass(this.getClass(), ViewState.class);
        mViewState = (VS) ViewModelProviders.of(this).get(vsClass);
        getLifecycle().addObserver(mViewState);

        mViewController = mViewState.getViewController();
        if (mViewController == null) {
            Class<VC> vcClass = ViewUtil.getTypeClass(this.getClass(), ViewController.class);
            try {
                mViewController = vcClass.newInstance();
                mViewController.setContext(this);
                mViewController.setLifecycleOwner(this);
                mViewController.setViewState(mViewState);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            mViewState.setViewController(mViewController);
        }
        mViewController.onCreate(getIntent().getExtras(), savedInstanceState);
    }

    public abstract View getContentView();

    public abstract void initContentView(View contentView);

    public abstract void observeViewState();

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
