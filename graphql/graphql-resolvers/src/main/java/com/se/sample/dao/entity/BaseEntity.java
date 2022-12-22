package com.se.sample.dao.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String brand;
    private String environment;
    private String locale;
    private String currency;

    public BaseEntity()
    {

    }

    public BaseEntity(String brand, String environment, String locale, String currency) {
        super();
        setBrand(brand);

        setEnvironment(StringUtils.defaultString(environment, "development"));
        setLocale(StringUtils.defaultString(locale, "en-us"));
        setCurrency(StringUtils.defaultString(currency, "USD"));
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
