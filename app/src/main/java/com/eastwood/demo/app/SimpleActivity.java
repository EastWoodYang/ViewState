package com.eastwood.demo.app;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eastwood.pattern.viewstate.ViewActivity;

public class SimpleActivity extends ViewActivity<SimpleState, SimpleController> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_simple);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewState().viewEvent.buttonClickEvent.setValue(true);
            }
        });

        final TextView content = findViewById(R.id.content);
        getViewState().viewData.contentState.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {
                content.setText("" + value.intValue());
            }
        });
    }
}
