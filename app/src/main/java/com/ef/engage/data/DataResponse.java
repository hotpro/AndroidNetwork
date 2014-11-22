package com.ef.engage.data;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/18/14
 */
public interface DataResponse <T> {
    public int getCode();
    public T getData();
    public long getLastUpdate();
}
