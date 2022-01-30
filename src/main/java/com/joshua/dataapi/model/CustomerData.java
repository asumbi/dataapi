package com.joshua.dataapi.model;

import javax.persistence.*;

@Entity
public class CustomerData {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private String language;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerdata")
    private Consent consent;

    public CustomerData(){

    }
    public Consent getConsent() {
        return consent;
    }

    public void setConsent(Consent consent) {
        this.consent = consent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", language='" + language + '\'' +
                ", consent=" + consent +
                '}';
    }
}
