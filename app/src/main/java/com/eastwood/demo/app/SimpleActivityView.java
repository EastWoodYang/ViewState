package com.eastwood.demo.app;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.eastwood.demo.app.base.BaseViewExtraActivity;

public class SimpleActivityView extends BaseViewExtraActivity<SimpleActivityViewState, SimpleActivityController> {

    private TextView mAddCountContent;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_simple;
    }

    @Override
    public void initContentView(View contentView) {
        super.initContentView(contentView);
        getViewExtras().getTitleBar().setDefaultTitleBarStyle("Simple Activity Title");

        mAddCountContent = contentView.findViewById(R.id.content);
        contentView.findViewById(R.id.btn_add_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.addCountEvent.setValue(true);
            }
        });

        contentView.findViewById(R.id.btn_open_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.openFragmentEvent.setValue(true);
            }
        });
    }

    @Override
    public void observeViewState() {
        super.observeViewState();

        getViewState().viewData.contentData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                if (value != null) {
                    mAddCountContent.setText(value.toString());
                }
            }
        });
    }

}
