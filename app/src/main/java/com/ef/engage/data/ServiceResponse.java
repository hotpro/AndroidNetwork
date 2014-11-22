package com.ef.engage.data;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/22/14
 */
public class ServiceResponse {
    private int errorCode;
    private String errorDescription;
    private ErrorMetaData errorMetaData;
    private int lastUpdate;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public ErrorMetaData getErrorMetaData() {
        return errorMetaData;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }
}
