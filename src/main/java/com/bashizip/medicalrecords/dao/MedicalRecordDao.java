/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bashizip.medicalrecords.dao;

import com.bashizip.medicalrecords.model.MedicalRecord;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class MedicalRecordDao {

    Database database = new Database();

    public MedicalRecordDao() {
        if (!database.getJsonDBTemplate().collectionExists(MedicalRecord.class)) {
            database.getJsonDBTemplate().createCollection(MedicalRecord.class);
        }
    }

    public void create(MedicalRecord mr) {
        database.getJsonDBTemplate().insert(mr);
    }

    public List<MedicalRecord> findAll() {
        List<MedicalRecord> instances = database.getJsonDBTemplate().findAll(MedicalRecord.class);
        return instances;
    }

    public static void main(String[] args) {
        MedicalRecord mr = new MedicalRecord();
        mr.setAge(12);
        mr.setCity("Kinshasa");
        mr.setCountry("DRC");
        mr.setGender("M");
        mr.setLivingWithDiabete("No");
        mr.setLname("Bashizi");
        mr.setFname("Bashizi");

        new MedicalRecordDao().create(mr);
    }
}
