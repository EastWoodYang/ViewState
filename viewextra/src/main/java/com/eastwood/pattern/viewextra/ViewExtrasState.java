package com.eastwood.pattern.viewextra;

import com.eastwood.pattern.viewextra.viewstate.DataEmptyViewState;
import com.eastwood.pattern.viewextra.viewstate.DialogViewState;
import com.eastwood.pattern.viewextra.viewstate.LoadingViewState;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;
import com.eastwood.pattern.viewextra.viewstate.StatusBarViewState;
import com.eastwood.pattern.viewextra.viewstate.TitleBarViewState;
import com.eastwood.pattern.viewextra.viewstate.ToastViewState;
import com.eastwood.pattern.viewstate.ViewState;

public class ViewExtrasState<VD extends ViewExtrasState.ViewData, VE extends ViewExtrasState.ViewEvent> extends ViewState<VD, VE>
        implements ViewExtrasViewStates {

    private DataEmptyViewState mDataEmptyViewState;
    private DialogViewState mDialogViewState;
    private LoadingViewState mLoadingViewState;
    private NetErrorViewState mNetErrorViewState;
    private StatusBarViewState mStatusBarViewState;
    private TitleBarViewState mTitleBarViewState;
    private ToastViewState mToastViewState;

    @Override
    public DataEmptyViewState getDataEmptyViewState() {
        if (mDataEmptyViewState == null) {
            mDataEmptyViewState = new DataEmptyViewState();
        }
        return mDataEmptyViewState;
    }

    @Override
    public DialogViewState getDialogViewState() {
        if (mDialogViewState == null) {
            mDialogViewState = new DialogViewState();
        }
        return mDialogViewState;
    }

    @Override
    public LoadingViewState getLoadingViewState() {
        if (mLoadingViewState == null) {
            mLoadingViewState = new LoadingViewState();
        }
        return mLoadingViewState;
    }

    @Override
    public NetErrorViewState getNetErrorViewState() {
        if (mNetErrorViewState == null) {
            mNetErrorViewState = new NetErrorViewState();
        }
        return mNetErrorViewState;
    }

    @Override
    public StatusBarViewState getStatusBarViewState() {
        if (mStatusBarViewState == null) {
            mStatusBarViewState = new StatusBarViewState();
        }
        return mStatusBarViewState;
    }

    @Override
    public TitleBarViewState getTitleBarViewState() {
        if (mTitleBarViewState == null) {
            mTitleBarViewState = new TitleBarViewState();
        }
        return mTitleBarViewState;
    }

    @Override
    public ToastViewState getToastViewState() {
        if (mToastViewState == null) {
            mToastViewState = new ToastViewState();
        }
        return mToastViewState;
    }

}
