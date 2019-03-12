package com.eastwood.demo.app;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eastwood.pattern.viewextra.ViewExtra;
import com.eastwood.pattern.viewextra.ViewExtrasActivity;
import com.eastwood.pattern.viewextra.viewstate.NetErrorViewState;

public class SimpleViewActivity extends ViewExtrasActivity<SimpleViewState, SimpleController> {

    private TextView content;
    private Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        content = findViewById(R.id.content);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.buttonClickEvent.setValue(true);
            }
        });

        getViewState().viewData.contentState.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                if (value != null) {
                    content.setText(value.toString());
                }
            }
        });

//        ViewExtra<NetErrorViewState> netErrorViewExtra = getViewExtras().getNetError();
//        netErrorViewExtra.createViewExtra();
//        netErrorViewExtra.getViewState().netErrorViewVisibleState.setValue(true);

        getViewExtras().getNetError().getViewState().actionButtonTextState.setValue("");

    }


    @Override
    public ViewGroup getDataEmptyContainer() {
        return null; // TODO
    }

    @Override
    public ViewGroup getLoadingContainer() {
        return null; // TODO
    }

    @Override
    public ViewGroup getNetErrorContainer() {
        return null; // TODO
    }

    @Override
    public ViewGroup getTitleBarContainer() {
        return null; // TODO
    }



}
