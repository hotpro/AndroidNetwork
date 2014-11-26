
package com.ef.engage.data.model;

import java.util.HashMap;
import java.util.Map;
public class Settings {

    private String minAppVersion;
    private String newAppVersion;
    private String newAppURL;
    private String appTrackingService1;
    private String productForStudent;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The minAppVersion
     */
    public String getMinAppVersion() {
        return minAppVersion;
    }

    /**
     * 
     * @param minAppVersion
     *     The minAppVersion
     */
    public void setMinAppVersion(String minAppVersion) {
        this.minAppVersion = minAppVersion;
    }

    /**
     * 
     * @return
     *     The newAppVersion
     */
    public String getNewAppVersion() {
        return newAppVersion;
    }

    /**
     * 
     * @param newAppVersion
     *     The newAppVersion
     */
    public void setNewAppVersion(String newAppVersion) {
        this.newAppVersion = newAppVersion;
    }

    /**
     * 
     * @return
     *     The newAppURL
     */
    public String getNewAppURL() {
        return newAppURL;
    }

    /**
     * 
     * @param newAppURL
     *     The newAppURL
     */
    public void setNewAppURL(String newAppURL) {
        this.newAppURL = newAppURL;
    }

    /**
     * 
     * @return
     *     The appTrackingService1
     */
    public String getAppTrackingService1() {
        return appTrackingService1;
    }

    /**
     * 
     * @param appTrackingService1
     *     The appTrackingService_1
     */
    public void setAppTrackingService1(String appTrackingService1) {
        this.appTrackingService1 = appTrackingService1;
    }

    /**
     * 
     * @return
     *     The productForStudent
     */
    public String getProductForStudent() {
        return productForStudent;
    }

    /**
     * 
     * @param productForStudent
     *     The productForStudent
     */
    public void setProductForStudent(String productForStudent) {
        this.productForStudent = productForStudent;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
