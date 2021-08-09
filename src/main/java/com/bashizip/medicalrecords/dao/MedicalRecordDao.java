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
        database.getJsonDBTemplate().createCollection(MedicalRecord.class);
    }

    public void create(MedicalRecord mr) {
        database.getJsonDBTemplate().insert(mr);
    }

    public List<MedicalRecord> findAll() {
        List<MedicalRecord> instances = database.getJsonDBTemplate().findAll(MedicalRecord.class);
        return instances;
    }
}
