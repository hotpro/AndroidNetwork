package com.ef.engage.data.net;

import com.ef.engage.data.ServiceResponse;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/22/14
 */
public class LoginResponse extends ServiceResponse{
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
}
