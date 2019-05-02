package com.eastwood.pattern.viewextra.activity;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.eastwood.pattern.viewextra.viewextra.ViewExtra;

/**
 * @author eastwood
 * createDate: 2019-03-28
 */
public class ActivityImpl implements ViewExtra<ActivityViewState> {

    private Activity mActivity;
    private LifecycleOwner mLifecycleOwner;
    private ActivityViewState mActivityViewState;

    private int mResultCode = Activity.RESULT_CANCELED;
    private Intent mResultData = null;

    public ActivityImpl(Activity activity, LifecycleOwner lifecycleOwner, ActivityViewState activityViewState) {
        this.mActivity = activity;
        this.mLifecycleOwner = lifecycleOwner;
        this.mActivityViewState = activityViewState;
    }

    @Override
    public void createViewExtra() {

        mActivityViewState.observeStartActivityInfoData(mLifecycleOwner, new Observer<StartActivityInfo>() {
            @Override
            public void onChanged(@Nullable StartActivityInfo startActivityInfo) {
                if (startActivityInfo == null) {
                    return;
                }

                mActivity.startActivityForResult(startActivityInfo.intent, startActivityInfo.requestCode);
            }
        });

        mActivityViewState.observeResultCodeData(mLifecycleOwner, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                if (integer != null) {
                    mResultCode = integer;
                }
            }
        });

        mActivityViewState.observeResultIntentData(mLifecycleOwner, new Observer<Intent>() {
            @Override
            public void onChanged(@Nullable Intent intent) {
                if (intent != null) {
                    mResultData = intent;
                }
            }
        });

        mActivityViewState.observeFinishData(mLifecycleOwner, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    mActivity.setResult(mResultCode, mResultData);
                    mActivity.finish();
                }
            }
        });
    }

    @Override
    public boolean isViewExtraCreated() {
        return true;
    }

    @Override
    public ActivityViewState getViewState() {
        return null;
    }

}
