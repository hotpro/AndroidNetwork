package com.ef.engage.data.impl;

import com.ef.engage.data.DataError;
import com.ef.engage.data.ErrorMetaData;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public class DefaultDataError implements DataError{
    private final int code;
    private final String message;
    private final ErrorMetaData errorMetaData;

    public DefaultDataError(int code, String message, ErrorMetaData errorMetaData) {
        this.code = code;
        this.message = message;
        this.errorMetaData = errorMetaData;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public ErrorMetaData getErrorMetaData() {
        return errorMetaData;
    }

    @Override
    public String toString() {
        return "DefaultDataError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", errorMetaData=" + errorMetaData +
                '}';
    }
}
