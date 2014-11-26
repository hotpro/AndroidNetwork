
package com.ef.engage.data.model;

import java.util.HashMap;
import java.util.Map;
public class Profile {

    private int memberId;
    private String userName;
    private String memberTypeCode;
    private String partnerCode;
    private String divisionCode;
    private String email;
    private String firstName;
    private String lastName;
    private String countryCode;
    private String gender;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * 
     * @param memberId
     *     The memberId
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * 
     * @return
     *     The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     *     The userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return
     *     The memberTypeCode
     */
    public String getMemberTypeCode() {
        return memberTypeCode;
    }

    /**
     * 
     * @param memberTypeCode
     *     The memberTypeCode
     */
    public void setMemberTypeCode(String memberTypeCode) {
        this.memberTypeCode = memberTypeCode;
    }

    /**
     * 
     * @return
     *     The partnerCode
     */
    public String getPartnerCode() {
        return partnerCode;
    }

    /**
     * 
     * @param partnerCode
     *     The partnerCode
     */
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    /**
     * 
     * @return
     *     The divisionCode
     */
    public String getDivisionCode() {
        return divisionCode;
    }

    /**
     * 
     * @param divisionCode
     *     The divisionCode
     */
    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
