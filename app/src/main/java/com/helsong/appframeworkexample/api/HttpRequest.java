package com.helsong.appframeworkexample.api;

import android.os.Debug;

import com.helsong.appframeworkexample.MyApp;
import com.helsong.appframeworkexample.util.Logger;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

/**
 * Created by weiruyou on 2015/5/7.
 */
public class HttpRequest {

    //God code.
//    static {
//        RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
//            @Override
//            public void handleError(Throwable e) {
//                Logger.dLog("RxJavaDebug", e.getMessage());
//            }
//        });
//    }

    private static HttpRequest mInstance;
    @Inject
    OkHttpClient mOkHttpClient;

    public static HttpRequest getInstance() {
        if (mInstance == null) {
            synchronized (HttpRequest.class) {
                if (mInstance == null) {
                    mInstance = new HttpRequest();
                }
            }
        }
        return mInstance;
    }

    private HttpRequest() {
        MyApp.getApp().inject(this);
    }

    public Observable<Response> requestSync(String url, boolean isGet, RequestParameters params) {
        if (url == null) {
            return null;
        }

        Request request = null;
        if (isGet) {
            if (params != null) {
                url = url + (url.contains("?") ? "&" : "?") + params.encodeUrl();
            }
            final String finalUrl = url;
            request = new Request.Builder().url(finalUrl).tag(finalUrl).build();
        } else {
            RequestBody requestBody = null;
            if (params != null) {
                requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), params.encodeUrl());
            }
            request = new Request.Builder().url(url).method("POST", requestBody).tag(url).build();
        }

        final Request finalRequest = request;
        return Observable.create(new Observable.OnSubscribe<Response>() {
            @Override
            public void call(Subscriber<? super Response> subscriber) {
                Response response = null;
                try {
                    response = mOkHttpClient.newCall(finalRequest).execute();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
                subscriber.onNext(response);
                subscriber.onCompleted();
            }
        });
    }
}
