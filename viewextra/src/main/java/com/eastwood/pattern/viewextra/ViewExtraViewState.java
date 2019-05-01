package com.eastwood.pattern.viewextra;

import com.eastwood.pattern.viewextra.viewextra.ViewExtraStates;
import com.eastwood.pattern.viewextra.viewextra.impl.ViewExtraStatesImpl;
import com.eastwood.pattern.viewstate.ViewState;

public class ViewExtraViewState<VD extends ViewExtraViewState.ViewData, VE extends ViewExtraViewState.ViewEvent> extends ViewState<VD, VE> {

    private ViewExtraStates mViewExtraStates;

    public ViewExtraStates getViewExtraStates() {
        if (mViewExtraStates == null) {
            mViewExtraStates = new ViewExtraStatesImpl();
        }

        return mViewExtraStates;
    }

}
