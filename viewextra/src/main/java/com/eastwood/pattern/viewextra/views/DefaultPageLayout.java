package com.eastwood.pattern.viewextra.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eastwood.pattern.viewextra.R;

public class DefaultPageLayout extends LinearLayout {

    public Button mActionButton;
    public ImageView mPictureImageView;
    public TextView mTipTextView;

    public DefaultPageLayout(Context context) {
        super(context);
        init(context);
    }

    public DefaultPageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(final Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.layout_default_page, this, true);
        mActionButton = findViewById(R.id.btn_action);
        mPictureImageView = findViewById(R.id.iv_default_page_picture);
        mTipTextView = findViewById(R.id.tv_default_page_tip);
    }

    public DefaultPageLayout setTip(String text) {
        mTipTextView.setText(text);
        mTipTextView.setVisibility(VISIBLE);
        return this;
    }

    public DefaultPageLayout setActionButtonText(String text) {
        mActionButton.setText(text);
        return this;
    }

    public DefaultPageLayout setActionButtonVisibility(boolean isShow) {
        mActionButton.setVisibility(isShow ? View.VISIBLE : View.GONE);
        return this;
    }

    public DefaultPageLayout setOnActionButtonClickListener(OnClickListener onClickListener) {
        mActionButton.setOnClickListener(onClickListener);
        return this;
    }

    public DefaultPageLayout setPictureResource(int res) {
        mPictureImageView.setImageResource(res);
        return this;
    }

}
