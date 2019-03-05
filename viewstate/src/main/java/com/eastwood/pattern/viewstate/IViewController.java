package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public interface IViewController<VS> {

    VS getViewState();

    void setViewState(VS viewState);

    void setLifecycleOwner(LifecycleOwner lifecycleOwner);

    LifecycleOwner getLifecycleOwner();

    void onCreate(Bundle savedInstanceState);

}
