package com.eastwood.pattern.viewextra;

import com.eastwood.pattern.viewextra.viewextra.ViewExtraStates;
import com.eastwood.pattern.viewstate.ViewController;

public class ViewExtraController<VS extends ViewExtraViewState> extends ViewController<VS> {

    public ViewExtraStates getViewExtraStates() {
        return getViewState().getViewExtraStates();
    }

}
