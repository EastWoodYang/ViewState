package com.eastwood.pattern.viewextra;


import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.DialogViewState;
import com.eastwood.pattern.viewextra.viewstate.LoadingViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;
import com.eastwood.pattern.viewextra.viewstate.StatusBarViewState;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewstate.ToastViewState;

public interface IViewExtras {

    ViewExtra<DataEmptyViewState> getDataEmpty();

    ViewExtra<DialogViewState> getDialog();

    ViewExtra<LoadingViewState> getLoading();

    ViewExtra<NetErrorViewState> getNetError();

    ViewExtra<StatusBarViewState> getStatusBar();

    ViewExtra<TitleBarViewState> getTitleBar();

    ViewExtra<ToastViewState> getToast();

}
