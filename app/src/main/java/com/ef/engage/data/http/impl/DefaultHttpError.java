package com.ef.engage.data.http.impl;

import com.ef.engage.data.http.HttpError;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public class DefaultHttpError implements HttpError{
    private final int statusCode;
    private final String message;

    public DefaultHttpError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
