package com.ef.engage.data.http;

import java.io.InputStream;
import java.util.Map;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/14/14
 */
public interface HttpResponse {
    public int getStatusCode();
    public byte[] getBody();
    public Map<String, String> getHeaders();
    public InputStream getInputSteam();
}
