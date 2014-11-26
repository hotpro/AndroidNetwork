package com.ef.engage.data.model;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 11/26/14
 */
public class BaseServiceRequest {

    private final int productId;
    private final String platform;
    private final String appVersion;

    public BaseServiceRequest(int productId, String platform, String appVersion) {
        this.productId = productId;
        this.platform = platform;
        this.appVersion = appVersion;
    }
}
