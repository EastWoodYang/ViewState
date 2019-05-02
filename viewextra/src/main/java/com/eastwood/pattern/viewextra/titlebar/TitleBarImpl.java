package com.eastwood.pattern.viewextra.titlebar;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eastwood.pattern.viewextra.R;

public class TitleBarImpl implements TitleBarViewExtra<TitleBarViewState> {

    private Context mContext;
    private LifecycleOwner mLifecycleOwner;
    private ViewGroup mContainer;
    private TitleBarViewState mTitleBarViewState;

    private View mTitleBarLayout;

    private LinearLayout mLeftViewContainerLayout;
    private LinearLayout mRightViewContainerLayout;
    private LinearLayout mCenterViewContainerLayout;

    private View.OnClickListener mLeftBackListener;

    public TitleBarImpl(Context context, LifecycleOwner lifecycleOwner, TitleBarViewState titleBarViewState, final ViewGroup container) {
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mContainer = container;
        this.mTitleBarViewState = titleBarViewState;
    }

    @Override
    public void createViewExtra() {
        mTitleBarLayout = LayoutInflater.from(mContext).inflate(R.layout.layout_title_bar, mContainer, false);
        mLeftViewContainerLayout = mTitleBarLayout.findViewById(R.id.linear_title_bar_left_container);
        mRightViewContainerLayout = mTitleBarLayout.findViewById(R.id.linear_title_bar_right_container);
        mCenterViewContainerLayout = mTitleBarLayout.findViewById(R.id.linear_title_bar_center_container);

        mContainer.addView(mTitleBarLayout);

    }

    @Override
    public boolean isViewExtraCreated() {
        return mTitleBarLayout != null;
    }

    @Override
    public TitleBarViewState getViewState() {
        return mTitleBarViewState;
    }

    @Override
    public void setDefaultTitleBarStyle() {
        setDefaultTitleBarStyle(null);
    }

    @Override
    public void setDefaultTitleBarStyle(String title) {
        createTitleBar();

        final TextView titleTextView = mCenterViewContainerLayout.findViewById(R.id.tv_title_bar_title);
        titleTextView.setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(title)) {
            titleTextView.setText(title);
        }
        mTitleBarViewState.observeTitleBarTitleData(mLifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String title) {
                if (TextUtils.isEmpty(title)) {
                    titleTextView.setText("");
                } else {
                    titleTextView.setText(title);
                }
            }
        });
    }

    @Override
    public void setDefaultTitleBarLeftBackStyle() {
        createTitleBar();
        final ImageView arrowBackImageView = mLeftViewContainerLayout.findViewById(R.id.iv_title_bar_arrow_back);
        arrowBackImageView.setVisibility(View.VISIBLE);
        arrowBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftBackListener == null) {
                    mTitleBarViewState.setTitleBarBackArrowClickEvent(true);
                } else {
                    mLeftBackListener.onClick(v);
                }
            }
        });
    }

    @Override
    public void setDefaultTitleBarLeftCloseStyle() {
        createTitleBar();
        final ImageView arrowBackImageView = mLeftViewContainerLayout.findViewById(R.id.iv_title_bar_arrow_back);
        arrowBackImageView.setImageResource(R.drawable.ic_title_bar_close);
        arrowBackImageView.setVisibility(View.VISIBLE);
        arrowBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftBackListener == null) {
                    mTitleBarViewState.setTitleBarBackArrowClickEvent(true);
                } else {
                    mLeftBackListener.onClick(v);
                }
            }
        });
    }

    @Override
    public void setWhiteTitleBarLeftBackStyle() {
        createTitleBar();
        final ImageView arrowBackImageView = mLeftViewContainerLayout.findViewById(R.id.iv_title_bar_arrow_back);
        arrowBackImageView.setVisibility(View.VISIBLE);
        arrowBackImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftBackListener == null) {
                    mTitleBarViewState.setTitleBarBackArrowClickEvent(true);
                } else {
                    mLeftBackListener.onClick(v);
                }
            }
        });
        hideTitleBarBottomLine();
    }

    @Override
    public void setDefaultTitleBarRightTextStyle(String action) {
        setDefaultTitleBarRightTextStyle(action, true);
    }

    @Override
    public void setDefaultTitleBarRightTextStyle(String action, boolean enable) {
        createTitleBar();
        final TextView rightActionTextView = mRightViewContainerLayout.findViewById(R.id.tv_title_bar_right_action);
        rightActionTextView.setText(action);
        rightActionTextView.setEnabled(enable);
        rightActionTextView.setVisibility(View.VISIBLE);
        rightActionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleBarViewState.setTitleBarRightActionClickEvent(true);
            }
        });
    }

    @Override
    public void setDefaultTitleBarRightTextStyleColor(int color) {
        createTitleBar();
        final TextView rightActionTextView = mRightViewContainerLayout.findViewById(R.id.tv_title_bar_right_action);
        rightActionTextView.setTextColor(color);
    }

    @Override
    public void setDefaultTitleBarRightTextEnable(boolean enable) {
        createTitleBar();
        final TextView rightActionTextView = mRightViewContainerLayout.findViewById(R.id.tv_title_bar_right_action);
        rightActionTextView.setEnabled(enable);
    }

    @Override
    public void setDefaultTitleBarRightTextVisible(boolean visible) {
        createTitleBar();
        final TextView rightActionTextView = mRightViewContainerLayout.findViewById(R.id.tv_title_bar_right_action);
        rightActionTextView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void addViewToTitleBarLeftContainer(View view) {
        if (view == null) return;
        createTitleBar();
        mLeftViewContainerLayout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void addViewToTitleBarCenterContainer(View view) {
        if (view == null) return;
        createTitleBar();
        mCenterViewContainerLayout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void addViewToTitleBarRightContainer(View view) {
        if (view == null) return;
        createTitleBar();
        mRightViewContainerLayout.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setDefaultTitleBarLeftVisible(boolean visible) {
        createTitleBar();
        final ImageView arrowBackImageView = mLeftViewContainerLayout.findViewById(R.id.iv_title_bar_arrow_back);
        arrowBackImageView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void hideDefaultTitleBar() {
        if (isViewExtraCreated()) {
            mTitleBarLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void hideTitleBarBottomLine() {
        mTitleBarLayout.findViewById(R.id.view_title_bar_bottom_line).setVisibility(View.GONE);
    }

    @Override
    public void setLeftBackListener(View.OnClickListener clickListener) {
        this.mLeftBackListener = clickListener;
    }

    @Override
    public void setLeftBackVisible(boolean show) {
        if (show) {
            setDefaultTitleBarLeftBackStyle();
        } else {
            createTitleBar();
            final ImageView arrowBackImageView = mLeftViewContainerLayout.findViewById(R.id.iv_title_bar_arrow_back);
            arrowBackImageView.setVisibility(View.GONE);
        }
    }

    private void createTitleBar() {
        if (!isViewExtraCreated()) {
            createViewExtra();
        }

        mTitleBarLayout.setVisibility(View.VISIBLE);

        if (isViewExtraCreated()) {
            mTitleBarLayout.setVisibility(View.VISIBLE);
        }
    }
}
