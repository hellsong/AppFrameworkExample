package com.helsong.appframeworkexample.modules;

import com.helsong.appframeworkexample.annotation.Named;
import com.helsong.appframeworkexample.presenters.Presenter;
import com.helsong.appframeworkexample.presenters.ReadmeInfoPresenter;
import com.helsong.appframeworkexample.presenters.RepoContriPresenter;
import com.helsong.appframeworkexample.ui.activity.ReadmeInfoActivity;
import com.helsong.appframeworkexample.ui.activity.RepoContributorsActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by weiruyou on 2015/5/7.
 */
@Module(
        injects = {
                RepoContributorsActivity.class,
                ReadmeInfoActivity.class
        },
        complete = true
)
public class UIModules {
    @Provides
    @Named("repoContributor")
    Presenter provideRepoContriPresentor() {
        return new RepoContriPresenter();
    }

    @Provides
    @Named("ReadmeInfo")
    Presenter provideReadmeInfoPresentor() {
        return new ReadmeInfoPresenter();
    }
}
