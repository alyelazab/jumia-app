package com.JumiaServices.task.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
public class CustomerInfo {
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "Customer_Name")
    private String name;

    @Column(name = "Phone_Number")
    private String number;

    @Column(name = "Country_Code")
    private String countryCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Number_State")
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
