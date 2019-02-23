package com.eastwood.demo.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eastwood.pattern.viewstate.ViewController;

public class SimpleController extends ViewController<SimpleState> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getViewState().viewData.contentState.setValue(0);

        getViewState().viewEvent.buttonClickEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                getViewState().viewData.contentState.setValue(getViewState().viewData.contentState.getValue() + 1);
            }
        });

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {}

}
