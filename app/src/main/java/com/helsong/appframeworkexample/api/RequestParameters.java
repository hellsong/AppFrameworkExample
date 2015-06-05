package com.helsong.appframeworkexample.api;

import android.text.TextUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

public class RequestParameters {
    private HashMap<String, String> map = new HashMap<String, String>();

    public RequestParameters() {
    }

    public RequestParameters(String key, String value) {
        add(key, value);
    }

    public RequestParameters(HashMap<String, String> input) {
        map.putAll(input);
    }

    public RequestParameters add(String key, double value) {
        if (!TextUtils.isEmpty(key))
            this.map.put(key, String.valueOf(value));
        return this;
    }

    public RequestParameters add(String key, int value) {
        if (!TextUtils.isEmpty(key))
            this.map.put(key, String.valueOf(value));
        return this;
    }

    public RequestParameters add(String key, long value) {
        if (!TextUtils.isEmpty(key))
            this.map.put(key, String.valueOf(value));
        return this;
    }

    public RequestParameters add(String key, String value) {
        if (!TextUtils.isEmpty(key))
            this.map.put(key, value);
        return this;
    }

    public RequestParameters addAll(RequestParameters params) {
        this.map.putAll(params.change2HashMap());
        return this;
    }

    public String getValue(String key) {
        return this.map.get(key);
    }

    public String remove(String key) {
        return this.map.remove(key);
    }

    public void clear() {
        this.map.clear();
    }

    public HashMap<String, String> change2HashMap() {
        return this.map;
    }

    public String encodeUrl() {
        StringBuilder localStringBuilder = new StringBuilder();
        for (Iterator<String> it = this.map.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            if (TextUtils.isEmpty(this.map.get(key)))
                continue;
            localStringBuilder.append(URLEncoder.encode(key)).append("=").append(URLEncoder.encode(this.map.get(key))).append("&");
        }
        if (localStringBuilder.length() != 0)
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        return localStringBuilder.toString();
    }

    public int size() {
        return this.map.size();
    }
}
