package com.eastwood.pattern.viewextra.viewextra;

public interface ViewExtra<VS> {

    void createViewExtra();

    boolean isViewExtraCreated();

    VS getViewState();

}
