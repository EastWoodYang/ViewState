package com.eastwood.demo.app;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eastwood.pattern.viewextra.ViewExtrasActivity;

public class SimpleViewActivity extends ViewExtrasActivity<SimpleViewState, SimpleController> {

    private TextView content;
    private Button button;

    @Override
    public int getContentView() {
        return R.layout.activity_simple;
    }

    @Override
    public void initContentView(View contentView) {
        content = contentView.findViewById(R.id.content);
        button = contentView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.buttonClickEvent.setValue(true);
            }
        });
    }

    @Override
    public void observerViewData() {

        getViewState().viewData.contentState.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                if (value != null) {
                    content.setText(value.toString());
                }
            }
        });
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
