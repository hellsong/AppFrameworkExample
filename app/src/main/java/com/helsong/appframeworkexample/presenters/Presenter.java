package com.helsong.appframeworkexample.presenters;

import android.content.Context;

import com.helsong.appframeworkexample.ui.viewinterface.MainView;

/**
 * Created by weiruyou on 2015/5/6.
 */
public interface Presenter {
    void onCreate(MainView mainView, Context context);

    void onTakeView();

    void onDropView();

    void onDestroy();
}
