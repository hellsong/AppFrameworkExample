package com.helsong.appframeworkexample.modules;

/**
 * Created by weiruyou on 2015/5/6.
 */
public class Modules {
    public static Object[] getModules() {
        return new Object[]{new APIModule(),new UIModules()};
    }
}
