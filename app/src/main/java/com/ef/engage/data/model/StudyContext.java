
package com.ef.engage.data.model;

import java.util.ArrayList;
import java.util.List;
public class StudyContext {

    private String siteVersion;
    private Profile profile;
    private Bootstrap bootstrap;
    private List<Enrollment> enrollments = new ArrayList<Enrollment>();

    /**
     * 
     * @return
     *     The siteVersion
     */
    public String getSiteVersion() {
        return siteVersion;
    }

    /**
     * 
     * @param siteVersion
     *     The siteVersion
     */
    public void setSiteVersion(String siteVersion) {
        this.siteVersion = siteVersion;
    }

    /**
     * 
     * @return
     *     The profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * 
     * @param profile
     *     The profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * 
     * @return
     *     The bootstrap
     */
    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    /**
     * 
     * @param bootstrap
     *     The bootstrap
     */
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    /**
     * 
     * @return
     *     The enrollments
     */
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    @Override
    public String toString() {
        return "StudyContext{" +
                "siteVersion='" + siteVersion + '\'' +
                ", profile=" + profile +
                ", bootstrap=" + bootstrap +
                ", enrollments=" + enrollments +
                '}';
    }
}
