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

    private IViewController<? extends ViewState> mViewController;

    public class ViewData {

    }

    public class ViewEvent {

    }

    public ViewState() {
        try {
            Class vmClass = ViewUtil.getTypeClass(this.getClass(), ViewData.class);
            Constructor<?>[] vmConstructors = vmClass.getDeclaredConstructors();
            viewData = (VD) vmConstructors[0].newInstance(this);

            Class veClass = ViewUtil.getTypeClass(this.getClass(), ViewEvent.class);
            Constructor<?>[] veConstructors = veClass.getDeclaredConstructors();
            viewEvent = (VE) veConstructors[0].newInstance(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IViewController<? extends ViewState> getViewController() {
        return this.mViewController;
    }

    void setViewController(IViewController<? extends ViewState> viewController) {
        this.mViewController = viewController;
    }

}
