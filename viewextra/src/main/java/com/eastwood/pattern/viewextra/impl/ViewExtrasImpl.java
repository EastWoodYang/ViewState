package com.eastwood.pattern.viewextra.impl;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.ViewExtrasContainers;
import com.eastwood.pattern.viewextra.IViewExtras;
import com.eastwood.pattern.viewextra.IViewExtrasViewStates;
import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.DialogViewState;
import com.eastwood.pattern.viewextra.viewstate.LoadingViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;
import com.eastwood.pattern.viewextra.viewstate.StatusBarViewState;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewstate.ToastViewState;

public class ViewExtrasImpl implements IViewExtras {

    private ViewExtra<DataEmptyViewState> dataEmpty;
    private ViewExtra<DialogViewState> dialog;
    private ViewExtra<LoadingViewState> loading;
    private ViewExtra<NetErrorViewState> netError;
    private ViewExtra<StatusBarViewState> statusBar;
    private ViewExtra<TitleBarViewState> titleBar;
    private ViewExtra<ToastViewState> toast;

    private Context context;
    private LifecycleOwner lifecycleOwner;
    private IViewExtrasViewStates IViewExtrasViewStates;
    private ViewExtrasContainers viewExtrasContainers;

    public ViewExtrasImpl(Context context, LifecycleOwner lifecycleOwner, IViewExtrasViewStates IViewExtrasViewStates, ViewExtrasContainers viewExtrasContainers) {
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        this.IViewExtrasViewStates = IViewExtrasViewStates;
        this.viewExtrasContainers = viewExtrasContainers;
    }

    @Override
    public ViewExtra<DataEmptyViewState> getDataEmpty() {
        if (dataEmpty == null) {
            dataEmpty = new DataEmptyImpl(context, lifecycleOwner, IViewExtrasViewStates.getDataEmptyViewState(), viewExtrasContainers.getDataEmptyContainer());
        }
        return dataEmpty;
    }

    @Override
    public ViewExtra<DialogViewState> getDialog() {
        if (dialog == null) {
            dialog = new DialogImpl(context, lifecycleOwner, IViewExtrasViewStates.getDialogViewState());
        }
        return dialog;
    }

    @Override
    public ViewExtra<LoadingViewState> getLoading() {
        if (loading == null) {
            loading = new LoadingImpl(context, lifecycleOwner, IViewExtrasViewStates.getLoadingViewState(), viewExtrasContainers.getLoadingContainer());
        }
        return loading;
    }

    @Override
    public ViewExtra<NetErrorViewState> getNetError() {
        if (netError == null) {
            netError = new NetErrorImpl(context, lifecycleOwner, IViewExtrasViewStates.getNetErrorViewState(), viewExtrasContainers.getNetErrorContainer());
        }
        return netError;
    }

    @Override
    public ViewExtra<StatusBarViewState> getStatusBar() {
        if (statusBar == null) {
            statusBar = new StatusBarImpl(context, lifecycleOwner, IViewExtrasViewStates.getStatusBarViewState());
        }
        return statusBar;
    }

    @Override
    public ViewExtra<TitleBarViewState> getTitleBar() {
        if (titleBar == null) {
            titleBar = new TitleBarImpl(context, lifecycleOwner, IViewExtrasViewStates.getTitleBarViewState(), viewExtrasContainers.getTitleBarContainer());
        }
        return titleBar;
    }

    @Override
    public ViewExtra<ToastViewState> getToast() {
        if (toast == null) {
            toast = new ToastImpl(context, lifecycleOwner, IViewExtrasViewStates.getToastViewState());
        }
        return toast;
    }

}
