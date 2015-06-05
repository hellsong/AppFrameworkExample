package com.helsong.appframeworkexample.util;

import android.util.Log;

/**
 * Created by weiruyou on 2015/5/19.
 */
public class Logger {
    private static boolean mDebug = true;

    public static void dLog(String tag, String message) {
        if (mDebug) {
            Log.d(tag, message);
        }
    }
}
