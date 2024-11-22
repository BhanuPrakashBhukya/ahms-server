package com.plea11.ahms.restmodels;

import com.plea11.ahms.common.restmodel.BaseRM;

public class HotelBranchesRM extends BaseRM {

    private long id;
    private long hotelId;
    private String hotelName;
    private String name;
    private String gmail;
    private String phoneNumber;
    private String address;
    private String addressfirstLine;
    private String addresssecondLine;
    private String city;
    private String state;
    private long stateId;
    private String country;
    private long countryId;
    private String zipCode;
    private int total;
    private int nonSuite;
    private int suite;
    private int nonSuiteAvailable;
    private int suiteAvailable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressfirstLine() {
        return addressfirstLine;
    }

    public void setAddressfirstLine(String addressfirstLine) {
        this.addressfirstLine = addressfirstLine;
    }

    public String getAddresssecondLine() {
        return addresssecondLine;
    }

    public void setAddresssecondLine(String addresssecondLine) {
        this.addresssecondLine = addresssecondLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNonSuite() {
        return nonSuite;
    }

    public void setNonSuite(int nonSuite) {
        this.nonSuite = nonSuite;
    }

    public int getSuite() {
        return suite;
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }

    public int getNonSuiteAvailable() {
        return nonSuiteAvailable;
    }

    public void setNonSuiteAvailable(int nonSuiteAvailable) {
        this.nonSuiteAvailable = nonSuiteAvailable;
    }

    public int getSuiteAvailable() {
        return suiteAvailable;
    }

    public void setSuiteAvailable(int suiteAvailable) {
        this.suiteAvailable = suiteAvailable;
    }

}
