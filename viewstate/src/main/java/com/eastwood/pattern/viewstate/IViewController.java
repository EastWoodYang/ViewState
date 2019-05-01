package com.eastwood.pattern.viewstate;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author eastwood
 * createDate: 2019-02-20
 */
public interface IViewController<VS> {

    Context getContext();

    void setContext(Context context);

    VS getViewState();

    void setViewState(VS viewState);

    void setLifecycleOwner(LifecycleOwner lifecycleOwner);

    LifecycleOwner getLifecycleOwner();

    void onCreate(Bundle intentData, Bundle savedInstanceState);

    void onNewIntent(Intent intent);

    void onViewCreated(Bundle savedInstanceState);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);

}
