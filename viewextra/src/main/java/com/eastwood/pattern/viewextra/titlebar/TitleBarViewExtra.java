package com.eastwood.pattern.viewextra.titlebar;

import android.view.View;

import com.eastwood.pattern.viewextra.viewextra.ViewExtra;

public interface TitleBarViewExtra<VS> extends ViewExtra<VS> {

    void setDefaultTitleBarStyle();

    void setDefaultTitleBarStyle(String title);

    void setDefaultTitleBarLeftBackStyle();

    void setDefaultTitleBarLeftCloseStyle();

    void setDefaultTitleBarLeftVisible(boolean visible);

    void setWhiteTitleBarLeftBackStyle();

    void setDefaultTitleBarRightTextStyle(String action);

    void setDefaultTitleBarRightTextStyle(String action, boolean enable);

    void setDefaultTitleBarRightTextStyleColor(int color);

    void setDefaultTitleBarRightTextEnable(boolean enable);

    void setDefaultTitleBarRightTextVisible(boolean visible);

    void addViewToTitleBarLeftContainer(View view);

    void addViewToTitleBarCenterContainer(View view);

    void addViewToTitleBarRightContainer(View view);

    void hideDefaultTitleBar();

    void hideTitleBarBottomLine();

    void setLeftBackListener(View.OnClickListener clickListener);

    void setLeftBackVisible(boolean show);

}
