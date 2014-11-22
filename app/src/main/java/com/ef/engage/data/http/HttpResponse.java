package com.ef.engage.data.http;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 */
public interface HttpResponse {
    public int getStatusCode();
    public byte[] getBody();
}
