package com.helsong.appframeworkexample.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.helsong.appframeworkexample.api.apiinterface.GitHubAPI;
import com.helsong.appframeworkexample.model.Contributor;
import com.squareup.okhttp.Response;

import java.lang.reflect.Type;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by weiruyou on 2015/5/7.
 */
public class GitHubAPIimpl implements GitHubAPI {
    private static final String API_URL = "https://api.github.com/repos/hellsong/DownloadProcessButton/contributors";

    @Override
    public Observable<List<Contributor>> getContributors() {
        return HttpRequest.getInstance().requestSync(API_URL, true, null).subscribeOn(Schedulers.newThread()).flatMap(new Func1<Response, Observable<List<Contributor>>>() {
            @Override
            public Observable<List<Contributor>> call(final Response response) {
                return Observable.create(new Observable.OnSubscribe<List<Contributor>>() {
                    @Override
                    public void call(Subscriber<? super List<Contributor>> subscriber) {
                        List<Contributor> list = null;
                        try {
                            Gson gson = new Gson();
                            Type listType = new TypeToken<List<Contributor>>() {
                            }.getType();
                            list = gson.fromJson(response.body().string(), listType);
                        } catch (Exception e) {
                            subscriber.onError(e);
                        }
                        subscriber.onNext(list);
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }
}
