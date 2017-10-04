package com.requestWrapper;

/**
 * @author Rodion Smakota <rsmakota@commercegate.com>
 * @since 2017-10-03
 * Copyright  "Commercegate LTD"
 */
public class ClientWrapper {
    private String msisdn;
    private Integer countryId;
    private String name;
    private String gender;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
