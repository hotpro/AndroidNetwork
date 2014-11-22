package com.ef.engage.data.http;

import com.ef.engage.data.http.impl.DefaultHttpRequest;
import com.ef.engage.data.http.impl.DefaultHttpService;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 */
public class ServiceProvider {
    private static HttpService efHttpService;

    public static HttpService getEFHttpService() {
        if (efHttpService == null) {
            efHttpService = new DefaultHttpService();
        }
        return efHttpService;
    }

    public static HttpRequest createRequest(String url, EFHttpRequestType type, String body) {
        return new DefaultHttpRequest(url, type, body);
    }

}
