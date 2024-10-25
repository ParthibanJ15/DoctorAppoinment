package com.appointmentsystem.appointmentsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MednDet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String medname;
    public String dossage;
    public String purposes;
    public String price;
    public MednDet(String medname, String dossage, String purposes, String price){
        this.medname=medname;
        this.dossage=dossage;
        this.purposes=purposes;
        this.price=price;
    }
    public MednDet(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }
    public String getDossage() {
        return dossage;
    }

    public void setDossage(String dossage) {
        this.dossage = dossage;
    }

    public String getPurposes() {
        return purposes;
    }

    public void setPurposes(String purposes) {
        this.purposes = purposes;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
