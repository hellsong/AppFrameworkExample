package com.helsong.appframeworkexample;

import android.app.Application;
import android.content.Context;

import com.helsong.appframeworkexample.modules.Modules;

import dagger.ObjectGraph;

/**
 * Created by weiruyou on 2015/5/6.
 */
public class MyApp extends Application {
    private ObjectGraph objectGraph;
    private static MyApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        buildObjectGraphAndInject();
    }

    public void buildObjectGraphAndInject() {
        objectGraph = ObjectGraph.create(Modules.getModules());
//        objectGraph.inject(this);
    }

    public void inject(Object o) {
        objectGraph.inject(o);
    }

    public static MyApp getApp() {
        return sInstance;
    }
}
