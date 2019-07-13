package com.chidha.rps.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SchoolAddressEntity {

    @Column(name = "STREET")
    private String street;

    @Column(name = "PIN_CODE")
    private long pincode;

    public SchoolAddressEntity() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
}
