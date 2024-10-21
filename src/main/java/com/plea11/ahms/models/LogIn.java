package com.plea11.ahms.models;

import com.plea11.ahms.common.model.BaseDBModel;

/**
 * @author bhukyabhanuprakash
 */

public class LogIn implements BaseDBModel {

    private String uniqueId;
    private String password;
    private String email;
    private String phoneNumber;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        uniqueId = uniqueId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
