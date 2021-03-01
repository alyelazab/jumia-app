package com.JumiaServices.task.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class CountryProps {
    @Id
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "country")
    private String country;

    @Column(name = "regex")
    private String regex;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryProps() {
    }

    public CountryProps(int id, String code, String country, String regex) {
        this.id = id;
        this.code = code;
        this.country = country;
        this.regex = regex;
    }
}