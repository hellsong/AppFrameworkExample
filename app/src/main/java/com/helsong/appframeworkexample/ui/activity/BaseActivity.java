package com.helsong.appframeworkexample.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.helsong.appframeworkexample.MyApp;

import butterknife.ButterKnife;

/**
 * Created by weiruyou on 2015/5/7.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.inject(this);
        MyApp.getApp().inject(this);
    }

    abstract protected int getLayoutID();
}
