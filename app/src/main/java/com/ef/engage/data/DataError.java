package com.ef.engage.data;

import com.ef.engage.data.ErrorMetaData;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public interface DataError {
    public int getCode();
    public String getMessage();
    public ErrorMetaData getErrorMetaData();
}
