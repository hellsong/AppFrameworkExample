package com.helsong.appframeworkexample.ui.viewinterface;

import com.helsong.appframeworkexample.model.Contributor;

import java.util.List;

/**
 * Created by weiruyou on 2015/5/7.
 */
public interface RepoContributorsView extends MainView {
    void showContributors(List<Contributor> list);
    void showErrorMessage(String msgString);
}
