package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.ViewExtraContainers;
import com.eastwood.pattern.viewextra.ViewExtras;
import com.eastwood.pattern.viewextra.ViewExtrasViewStates;
import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.DialogViewState;
import com.eastwood.pattern.viewextra.viewstate.LoadingViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;
import com.eastwood.pattern.viewextra.viewstate.StatusBarViewState;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewstate.ToastViewState;

public class ViewExtrasImpl implements ViewExtras {

    private ViewExtra<DataEmptyViewState> dataEmpty;
    private ViewExtra<DialogViewState> dialog;
    private ViewExtra<LoadingViewState> loading;
    private ViewExtra<NetErrorViewState> netError;
    private ViewExtra<StatusBarViewState> statusBar;
    private ViewExtra<TitleBarViewState> titleBar;
    private ViewExtra<ToastViewState> toast;

    private Context context;
    private LifecycleOwner lifecycleOwner;
    private ViewExtrasViewStates viewExtrasViewStates;
    private ViewExtraContainers viewExtraContainers;

    public ViewExtrasImpl(Context context, LifecycleOwner lifecycleOwner, ViewExtrasViewStates viewExtrasViewStates, ViewExtraContainers viewExtraContainers) {
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        this.viewExtrasViewStates = viewExtrasViewStates;
        this.viewExtraContainers = viewExtraContainers;
    }

    @Override
    public ViewExtra<DataEmptyViewState> getDataEmpty() {
        if (dataEmpty == null) {
            dataEmpty = new DataEmptyImpl(context, lifecycleOwner, viewExtrasViewStates.getDataEmptyViewState(), viewExtraContainers.getDataEmptyContainer());
        }
        return dataEmpty;
    }

    @Override
    public ViewExtra<DialogViewState> getDialog() {
        if (dialog == null) {
            dialog = new DialogImpl(context, lifecycleOwner, viewExtrasViewStates.getDialogViewState());
        }
        return dialog;
    }

    @Override
    public ViewExtra<LoadingViewState> getLoading() {
        if (loading == null) {
            loading = new LoadingImpl(context, lifecycleOwner, viewExtrasViewStates.getLoadingViewState(), viewExtraContainers.getLoadingContainer());
        }
        return loading;
    }

    @Override
    public ViewExtra<NetErrorViewState> getNetError() {
        if (netError == null) {
            netError = new NetErrorImpl(context, lifecycleOwner, viewExtrasViewStates.getNetErrorViewState(), viewExtraContainers.getNetErrorContainer());
        }
        return netError;
    }

    @Override
    public ViewExtra<StatusBarViewState> getStatusBar() {
        if (statusBar == null) {
            statusBar = new StatusBarImpl(context, lifecycleOwner, viewExtrasViewStates.getStatusBarViewState());
        }
        return statusBar;
    }

    @Override
    public ViewExtra<TitleBarViewState> getTitleBar() {
        if (titleBar == null) {
            titleBar = new TitleBarImpl(context, lifecycleOwner, viewExtrasViewStates.getTitleBarViewState(), viewExtraContainers.getTitleBarContainer());
        }
        return titleBar;
    }

    @Override
    public ViewExtra<ToastViewState> getToast() {
        if (toast == null) {
            toast = new ToastImpl(context, lifecycleOwner, viewExtrasViewStates.getToastViewState());
        }
        return toast;
    }

}
