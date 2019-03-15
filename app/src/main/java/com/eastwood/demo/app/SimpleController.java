package com.eastwood.demo.app;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;

public class SimpleController extends BizViewExtrasController<SimpleViewViewState> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);

        getViewState().viewData.contentState.setValue(0);

        getViewState().viewEvent.addCountEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                getViewState().viewData.contentState.setValue(getViewState().viewData.contentState.getValue() + 1);
            }
        });

        getViewState().viewEvent.showDataEmptyEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                DataEmptyViewState dataEmptyViewState = getViewState().getDataEmptyViewState();
                dataEmptyViewState.dataEmptyViewVisibleState.setValue(true);

            }
        });

        getViewState().viewEvent.showNetErrorEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                NetErrorViewState netErrorViewState = getViewState().getNetErrorViewState();
                netErrorViewState.netErrorViewVisibleState.setValue(true);

            }
        });

        NetErrorViewState netErrorViewState = getViewState().getNetErrorViewState();
        netErrorViewState.netErrorRetryClickEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.d("SimpleController", "net Error Retry Click Event");
            }
        });

        DataEmptyViewState dataEmptyViewState = getViewState().getDataEmptyViewState();
        dataEmptyViewState.dataEmptyRetryClickEvent.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                Log.d("SimpleController", "data Empty Retry Click Event");
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
