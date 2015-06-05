package com.helsong.appframeworkexample.presenters;

import android.content.Context;

import com.helsong.appframeworkexample.MyApp;
import com.helsong.appframeworkexample.api.apiinterface.ReadmeAPI;
import com.helsong.appframeworkexample.ui.viewinterface.MainView;
import com.helsong.appframeworkexample.ui.viewinterface.ReadmeInfoView;
import com.helsong.appframeworkexample.util.Logger;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by weiruyou on 2015/5/19.
 */
public class ReadmeInfoPresenter implements Presenter {
    private final static String TAG = ReadmeInfoPresenter.class.getSimpleName();
    private ReadmeInfoView mReadmeInfoView;
    @Inject
    ReadmeAPI mReadmeAPI;
    private Subscription mSubscription;

    @Override
    public void onCreate(MainView mainView, Context context) {
        MyApp.getApp().inject(this);
        mReadmeInfoView = (ReadmeInfoView) mainView;
    }

    @Override
    public void onTakeView() {
        mSubscription = mReadmeAPI.getReadmeInfo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                mReadmeInfoView.showReadmeInfo(s);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mReadmeInfoView.showReadmeInfo("Error:" + throwable.toString());
            }
        });
    }

    @Override
    public void onDropView() {

    }

    @Override
    public void onDestroy() {
        mSubscription.unsubscribe();
    }
}
