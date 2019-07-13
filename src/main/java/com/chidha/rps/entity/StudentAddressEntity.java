package com.chidha.rps.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAddressEntity {

    @Column(name = "STREET")
    private String address;

    @Column(name = "PIN_CODE")
    private long pincode;

    public StudentAddressEntity() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }
}
