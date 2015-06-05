package com.helsong.appframeworkexample.api.apiinterface;

import com.helsong.appframeworkexample.model.Contributor;

import rx.Observable;

/**
 * Created by weiruyou on 2015/5/19.
 */
public interface ReadmeAPI {
    Observable<String> getReadmeInfo();
}
