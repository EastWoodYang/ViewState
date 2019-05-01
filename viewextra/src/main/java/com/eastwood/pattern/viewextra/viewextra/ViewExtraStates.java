package com.eastwood.pattern.viewextra.viewextra;

import com.eastwood.pattern.viewextra.activity.ActivityViewState;
import com.eastwood.pattern.viewextra.titlebar.TitleBarViewState;

public interface ViewExtraStates {

    TitleBarViewState getTitleBar();

    ActivityViewState getActivity();

}
