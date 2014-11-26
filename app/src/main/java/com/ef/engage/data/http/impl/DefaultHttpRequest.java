package com.ef.engage.data.http.impl;

import com.ef.engage.data.http.HttpRequest;
import com.ef.engage.data.http.HttpService;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 */
public class DefaultHttpRequest implements HttpRequest {
    private String url;
    private HttpService.Method method;
    private String body;

    public DefaultHttpRequest(String url, HttpService.Method method, String body) {

        this.url = url;
        this.method = method;
        this.body = body;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public HttpService.Method getMethod() {
        return method;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "DefaultHttpRequest{" +
                "url='" + url + '\'' +
                ", method=" + method +
                ", body='" + body + '\'' +
                '}';
    }
}
