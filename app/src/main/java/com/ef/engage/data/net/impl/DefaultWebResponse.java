package com.ef.engage.data.net.impl;

import com.ef.engage.data.net.WebResponse;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public class DefaultWebResponse <T> implements WebResponse {

    private final int code;
    private final T data;
    private final long lastUpdate;

    public DefaultWebResponse(int code, T data, long lastUpdate) {
        this.code = code;
        this.data = data;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public long getLastUpdate() {
        return lastUpdate;
    }
}
