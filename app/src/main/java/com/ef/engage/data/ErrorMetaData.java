package com.ef.engage.data;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/19/14
 */
public class ErrorMetaData {
    private String errorTypeCode;
    private String startupTitle;
    private String startupMessage;
    private String correctDownloadURL;

    public ErrorMetaData(String errorTypeCode, String startupTitle, String startupMessage, String correctDownloadURL) {
        this.errorTypeCode = errorTypeCode;
        this.startupTitle = startupTitle;
        this.startupMessage = startupMessage;
        this.correctDownloadURL = correctDownloadURL;
    }

    public String getErrorTypeCode() {
        return errorTypeCode;
    }

    public String getStartupTitle() {
        return startupTitle;
    }

    public String getStartupMessage() {
        return startupMessage;
    }

    public String getCorrectDownloadURL() {
        return correctDownloadURL;
    }
}
