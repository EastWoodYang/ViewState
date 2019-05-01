package com.eastwood.pattern.viewextra.viewextra;


import com.eastwood.pattern.viewextra.activity.ActivityViewState;
import com.eastwood.pattern.viewextra.titlebar.TitleBarViewExtra;
import com.eastwood.pattern.viewextra.titlebar.TitleBarViewState;

public interface ViewExtras {

    ViewExtraStates getViewExtraStates();

    TitleBarViewExtra<TitleBarViewState> getTitleBar();

    ViewExtra<ActivityViewState> getActivity();

}
