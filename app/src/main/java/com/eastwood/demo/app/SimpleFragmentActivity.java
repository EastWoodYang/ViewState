package com.eastwood.demo.app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.eastwood.demo.app.base.CommonViewExtraActivity;

/**
 * @author eastwood
 * createDate: 2019-03-14
 */
public class SimpleFragmentActivity extends CommonViewExtraActivity {

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_empty;
    }

    @Override
    public void initContentView(View contentView) {
        super.initContentView(contentView);

        SimpleFragmentView fragment = new SimpleFragmentView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(android.R.id.content, fragment);
        transaction.commit();
    }
}
