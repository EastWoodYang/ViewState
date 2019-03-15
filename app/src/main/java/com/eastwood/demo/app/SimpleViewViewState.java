package com.eastwood.demo.app;

import android.arch.lifecycle.MutableLiveData;

import com.eastwood.pattern.viewextra.ViewExtrasViewState;
import com.eastwood.pattern.viewstate.SingleLiveEvent;


public class SimpleViewViewState extends ViewExtrasViewState<SimpleViewViewState.ViewData, SimpleViewViewState.ViewEvent> {

    public class ViewData extends ViewExtrasViewState.ViewData {

        public MutableLiveData<Integer> contentState = new MutableLiveData<>();

    }

    public class ViewEvent extends ViewExtrasViewState.ViewEvent {

        public SingleLiveEvent<Boolean> addCountEvent = new SingleLiveEvent<>();
        public SingleLiveEvent<Boolean> showDataEmptyEvent = new SingleLiveEvent<>();
        public SingleLiveEvent<Boolean> showNetErrorEvent = new SingleLiveEvent<>();


    }

}
