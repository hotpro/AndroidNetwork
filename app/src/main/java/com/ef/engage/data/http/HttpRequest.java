package com.ef.engage.data.http;

import java.util.Map;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 */
public interface HttpRequest {
    public String getUrl();
    public HttpService.Method getMethod();
    public String getBody();
    public Map<String, String> getHeaders();
}
