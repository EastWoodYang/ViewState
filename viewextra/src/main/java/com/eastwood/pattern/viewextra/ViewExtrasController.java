package com.eastwood.pattern.viewextra;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.eastwood.pattern.viewstate.ViewController;

public class ViewExtrasController<VS extends ViewExtrasViewState> extends ViewController<VS> {

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        getViewState().getNetErrorViewState().netErrorViewVisibleState.observe(getLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {

            }
        });
    }

}
