package com.joshua.dataapi.model;

import javax.persistence.*;

@Entity
public class Consent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private Boolean consent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "data_id", referencedColumnName = "id")
    private CustomerData customerdata;

    public Consent(){

    }

    public CustomerData getCustomerdata() {
        return customerdata;
    }

    public void setCustomerdata(CustomerData customerdata) {
        this.customerdata = customerdata;
    }

    public int getId() {
        return id;
    }

    public void setId(int dialog_id) {
        this.id = dialog_id;
    }

    public Boolean getConsent() {
        return consent;
    }

    public void setConsent(Boolean consent) {
        this.consent = consent;
    }
/*
    @Override
    public String toString() {
        return "Consent{" +
                "id=" + id +
                ", consent=" + consent +
                ", customerdata=" + customerdata.toString() +
                '}';
    }
 */
}
