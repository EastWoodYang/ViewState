package com.eastwood.pattern.viewextra;


import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.DialogViewState;
import com.eastwood.pattern.viewextra.viewstate.LoadingViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;
import com.eastwood.pattern.viewextra.viewstate.StatusBarViewState;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewstate.ToastViewState;

public interface ViewExtrasViewStates {

    DataEmptyViewState getDataEmptyViewState();

    DialogViewState getDialogViewState();

    LoadingViewState getLoadingViewState();

    NetErrorViewState getNetErrorViewState();

    StatusBarViewState getStatusBarViewState();

    TitleBarViewState getTitleBarViewState();

    ToastViewState getToastViewState();

}
