package com.eastwood.demo.app;

import android.arch.lifecycle.MutableLiveData;

import com.eastwood.pattern.viewextra.ViewExtraViewState;
import com.eastwood.pattern.viewstate.SingleLiveEvent;


public class SimpleActivityViewState extends ViewExtraViewState<SimpleActivityViewState.ViewData, SimpleActivityViewState.ViewEvent> {

    public class ViewData extends ViewExtraViewState.ViewData {

        public MutableLiveData<Integer> contentData = new MutableLiveData<>();

    }

    public class ViewEvent extends ViewExtraViewState.ViewEvent {

        public SingleLiveEvent<Boolean> addCountEvent = new SingleLiveEvent<>();

        public SingleLiveEvent<Boolean> openFragmentEvent = new SingleLiveEvent<>();

    }

}
