package com.eastwood.demo.app;

import android.arch.lifecycle.MutableLiveData;

import com.eastwood.pattern.viewextra.ViewExtrasState;
import com.eastwood.pattern.viewstate.SingleLiveEvent;


public class SimpleViewState extends ViewExtrasState<SimpleViewState.ViewData, SimpleViewState.ViewEvent> {

    public class ViewData extends ViewExtrasState.ViewData {

        public MutableLiveData<Integer> contentState = new MutableLiveData<>();

    }

    public class ViewEvent extends ViewExtrasState.ViewEvent {

        public SingleLiveEvent<Boolean> buttonClickEvent = new SingleLiveEvent<>();

    }

}
