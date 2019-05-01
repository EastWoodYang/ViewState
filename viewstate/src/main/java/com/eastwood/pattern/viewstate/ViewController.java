package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public abstract class ViewController<VS extends ViewState> implements IViewController<VS>, LifecycleObserver {

    private Context mContext;

    private LifecycleOwner mLifecycleOwner;

    private VS mViewState;

    private Intent mIntent;

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle intentData, Bundle savedInstanceState) {
        mLifecycleOwner.getLifecycle().addObserver(this);
        mIntent = new Intent();
        if (intentData != null) {
            mIntent.putExtras(intentData);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (mIntent == null) {
            mIntent = new Intent(intent);
        } else {
            mIntent.putExtras(intent);
        }
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    @Override
    public VS getViewState() {
        return mViewState;
    }

    @Override
    public void setViewState(VS viewState) {
        this.mViewState = viewState;
    }

    @Override
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public Intent getIntent() {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        return mIntent;
    }

}
