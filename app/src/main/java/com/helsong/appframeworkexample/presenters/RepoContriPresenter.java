package com.helsong.appframeworkexample.presenters;

import android.content.Context;

import com.helsong.appframeworkexample.MyApp;
import com.helsong.appframeworkexample.api.apiinterface.GitHubAPI;
import com.helsong.appframeworkexample.model.Contributor;
import com.helsong.appframeworkexample.ui.viewinterface.MainView;
import com.helsong.appframeworkexample.ui.viewinterface.RepoContributorsView;
import com.helsong.appframeworkexample.util.Logger;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by weiruyou on 2015/5/7.
 */
public class RepoContriPresenter implements Presenter {
    private final static String TAG = RepoContriPresenter.class.getSimpleName();
    @Inject
    GitHubAPI mGitHubAPI;

    private RepoContributorsView mRepoContributorsView;
    private Subscription mSubscription;

    @Override
    public void onCreate(MainView mainView, Context context) {
        mRepoContributorsView = (RepoContributorsView) mainView;
        MyApp.getApp().inject(this);
    }

    @Override
    public void onTakeView() {
        mSubscription = mGitHubAPI.getContributors().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<Contributor>>() {
            @Override
            public void call(List<Contributor> list) {
                mRepoContributorsView.showContributors(list);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.dLog(TAG, throwable.getMessage());
            }
        });
    }

    @Override
    public void onDropView() {
    }

    @Override
    public void onDestroy() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }
}
