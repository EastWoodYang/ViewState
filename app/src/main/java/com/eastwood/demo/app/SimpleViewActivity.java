package com.eastwood.demo.app;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleViewActivity extends BizViewExtrasActivity<SimpleViewViewState, SimpleController> {

    private TextView mAddCountContent;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_simple;
    }

    @Override
    public void initContentView(View contentView) {
        super.initContentView(contentView);

        getViewExtras().getTitleBar().createViewExtra();

        mAddCountContent = contentView.findViewById(R.id.content);
        contentView.findViewById(R.id.btn_add_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.addCountEvent.setValue(true);
            }
        });

        contentView.findViewById(R.id.btn_show_data_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.showDataEmptyEvent.setValue(true);
            }
        });

        contentView.findViewById(R.id.btn_show_net_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.showNetErrorEvent.setValue(true);
            }
        });

        contentView.findViewById(R.id.btn_open_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimpleViewActivity.this, SimpleFragmentActivity.class));
            }
        });
    }

    @Override
    public void observeViewState() {
        super.observeViewState();

        getViewState().viewData.contentState.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                if (value != null) {
                    mAddCountContent.setText(value.toString());
                }
            }
        });
    }

    @Override
    public ViewGroup getDataEmptyContainer() {
        return findViewById(R.id.container);
    }

    @Override
    public ViewGroup getLoadingContainer() {
        return null; // TODO
    }

    @Override
    public ViewGroup getNetErrorContainer() {
        return findViewById(R.id.container);
    }

    @Override
    public ViewGroup getTitleBarContainer() {
        return findViewById(R.id.title_bar_container);
    }

}
