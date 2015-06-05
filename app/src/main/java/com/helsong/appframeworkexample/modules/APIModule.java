package com.helsong.appframeworkexample.modules;

import com.helsong.appframeworkexample.api.ReadmeAPIimpl;
import com.helsong.appframeworkexample.api.apiinterface.GitHubAPI;
import com.helsong.appframeworkexample.api.GitHubAPIimpl;
import com.helsong.appframeworkexample.api.HttpRequest;
import com.helsong.appframeworkexample.api.apiinterface.ReadmeAPI;
import com.helsong.appframeworkexample.presenters.ReadmeInfoPresenter;
import com.helsong.appframeworkexample.presenters.RepoContriPresenter;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by weiruyou on 2015/5/7.
 */
@Module(
        injects = {
                HttpRequest.class,
                RepoContriPresenter.class,
                ReadmeInfoPresenter.class
        },
        complete = true
)
public class APIModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        return client;
    }

    @Provides
    @Singleton
    GitHubAPI provideGitHubAPI() {
        return new GitHubAPIimpl();
    }

    @Provides
    @Singleton
    ReadmeAPI provideReadmeAPI() {
        return new ReadmeAPIimpl();
    }
}
