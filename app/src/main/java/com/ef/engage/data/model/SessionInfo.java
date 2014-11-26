package com.ef.engage.data.model;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/26/14
 */
public class SessionInfo {
    private String token;
    private String sessionId;
    private String memberId;

    public String getToken() {
        return token;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "SessionInfo{" +
                "token='" + token + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
