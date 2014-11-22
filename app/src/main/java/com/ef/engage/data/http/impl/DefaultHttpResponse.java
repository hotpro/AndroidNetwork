package com.ef.engage.data.http.impl;

import com.ef.engage.data.http.HttpResponse;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public class DefaultHttpResponse implements HttpResponse {
    private final int statudCode;
    private final byte[] body;

    public DefaultHttpResponse(int statudCode, byte[] body) {
        this.statudCode = statudCode;
        this.body = body;
    }

    @Override
    public int getStatusCode() {
        return statudCode;
    }

    @Override
    public byte[] getBody() {
        return body;
    }
}
