package com.plea11.ahms.restmodels;

import com.plea11.ahms.common.restmodel.BaseRM;

/**
 * @author bhukyabhanuprakash
 */

public class LogInRM extends BaseRM {

    private String uniqueId;
    private String email;
    private String phoneNumber;

    private String identifier;

    private String password;

    private boolean isHotel;

    public LogInRM() {
    }

    public LogInRM(String identifier, String password, boolean isHotel) {
        this.identifier = identifier;
        this.password = password;
        this.isHotel = isHotel;
    }

    // Getter and Setter for identifier
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHotel() {
        return isHotel;
    }

    public void setHotel(boolean isHotel) {
        this.isHotel = isHotel;
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
