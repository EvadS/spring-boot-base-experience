package com.se.sample.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class PricingOptions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subscriptionType;
    private String customerType;
    private String personalizationType;

    public String getSubscriptionType() {
        return subscriptionType;
    }
    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
    public String getCustomerType() {
        return customerType;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public String getPersonalizationType() {
        return personalizationType;
    }
    public void setPersonalizationType(String personalizationType) {
        this.personalizationType = personalizationType;
    }
    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("PricingOptions [subscriptionType=");
        builder.append(subscriptionType);
        builder.append(", customerType=");
        builder.append(customerType);
        builder.append(", personalizationType=");
        builder.append(personalizationType);
        builder.append("]");
        return builder.toString();
    }


}
