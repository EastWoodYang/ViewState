package com.eastwood.demo.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eastwood.demo.app.base.BaseViewExtraController;

public class SimpleFragmentController extends BaseViewExtraController<SimpleFragmentViewState> {

    @Override
    public void onCreate(Bundle intentData, Bundle savedInstanceState) {
        super.onCreate(intentData, savedInstanceState);
    }


    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);

        getViewState().viewData.contentData.setValue(0);

        getViewState().viewEvent.addCountEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                getViewState().viewData.contentData.setValue(getViewState().viewData.contentData.getValue() + 1);
            }
        });

        getViewState().viewEvent.finishEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                getViewExtraStates().getActivity().finish();
            }
        });

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

}
