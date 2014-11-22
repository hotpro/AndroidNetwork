package com.ef.engage.data.http;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 *
 * feed "net layer" what they need
 * http status code, IOE, UnhostE, String resp,
 */
public interface HttpService {
    public enum Method {
        GET,
        POST
    }

    public void exec(HttpRequest request, HttpRequestHandler httpRequestHandler);

}
