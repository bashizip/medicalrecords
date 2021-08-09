/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bashizip.medicalrecords.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

/**
 *
 * @author Patrick
 */
@Document(collection = "medicalrecords", schemaVersion = "1.0")
public class MedicalRecord {

    @Id
    private String patientId;
    private String fname;
    private String lname;
    private String gender;
    private int age;
    private String city;
    private String country;
    private String livingWithDiabete;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLivingWithDiabete() {
        return livingWithDiabete;
    }

    public void setLivingWithDiabete(String livingWithDiabete) {
        this.livingWithDiabete = livingWithDiabete;
    }

}
