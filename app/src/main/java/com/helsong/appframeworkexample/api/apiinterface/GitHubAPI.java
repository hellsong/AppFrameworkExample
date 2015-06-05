package com.helsong.appframeworkexample.api.apiinterface;

import com.helsong.appframeworkexample.model.Contributor;

import java.util.List;

import rx.Observable;

/**
 * Created by weiruyou on 2015/5/6.
 */
public interface GitHubAPI {
    Observable<List<Contributor>> getContributors();
}
