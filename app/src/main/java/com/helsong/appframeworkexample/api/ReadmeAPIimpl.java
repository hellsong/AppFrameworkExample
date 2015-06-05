package com.helsong.appframeworkexample.api;

import com.helsong.appframeworkexample.api.apiinterface.ReadmeAPI;
import com.squareup.okhttp.Response;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by weiruyou on 2015/5/19.
 */
public class ReadmeAPIimpl implements ReadmeAPI {
    //    private static final String API_URL = "https://baidu.com";
    private static final String API_URL = "https://raw.github.com/square/okhttp/master/README.md";

    @Override
    public Observable<String> getReadmeInfo() {
        return HttpRequest.getInstance().requestSync(API_URL, true, null).subscribeOn(Schedulers.newThread()).flatMap(new Func1<Response, Observable<String>>() {
            @Override
            public Observable<String> call(final Response response) {
                return Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        String bodyString = null;
                        try {
                            bodyString = response.body().string();
                        } catch (Exception e) {
                            subscriber.onError(e);
                        }
                        subscriber.onNext(bodyString);
                        subscriber.onCompleted();
                    }
                });
            }
        });
    }
}
