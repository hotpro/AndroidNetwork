package com.ef.engage.data.net;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public interface WebResponse <T> {
    public int getCode();
    public T getData();
    public long getLastUpdate();
}
