package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModel;

import java.lang.reflect.Constructor;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public class ViewState<VD extends ViewState.ViewData, VE extends ViewState.ViewEvent> extends ViewModel implements LifecycleObserver {

    public VD viewData;

    public VE viewEvent;

    public ViewState() {
        try {
            Class vmClass = ViewUtil.getTypeClass(this, 0);
            Constructor<?>[] vmConstructors = vmClass.getDeclaredConstructors();
            viewData = (VD) vmConstructors[0].newInstance(this);

            Class veClass = ViewUtil.getTypeClass(this, 1);
            Constructor<?>[] veConstructors = veClass.getDeclaredConstructors();
            viewEvent = (VE) veConstructors[0].newInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ViewData {

    }

    public class ViewEvent {

    }

    private IViewController mViewController;

    void setViewController(IViewController viewController) {
        this.mViewController = viewController;
    }

    public IViewController getViewController() {
        return this.mViewController;
    }

}
