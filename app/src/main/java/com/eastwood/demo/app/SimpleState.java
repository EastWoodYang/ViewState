package com.eastwood.demo.app;

import android.arch.lifecycle.MutableLiveData;

import com.eastwood.pattern.viewstate.SingleLiveEvent;
import com.eastwood.pattern.viewstate.ViewState;


public class SimpleState extends ViewState<SimpleState.LoginViewData, SimpleState.LoginViewEvent> {

    public class LoginViewData extends ViewState.ViewData {

        public MutableLiveData<Integer> contentState = new MutableLiveData<>();

    }

    public class LoginViewEvent extends ViewState.ViewEvent {

        public SingleLiveEvent<Boolean> buttonClickEvent = new SingleLiveEvent<>();

    }

}
