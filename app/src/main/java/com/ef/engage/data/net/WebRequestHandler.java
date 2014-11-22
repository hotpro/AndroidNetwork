package com.ef.engage.data.net;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public interface WebRequestHandler <T> {
    public void onStart();
    public void onSuccess(WebResponse<T> webResponse);
    public void onError(WebError webError);
}
