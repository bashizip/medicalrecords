/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bashizip.medicalrecords.service;

import com.bashizip.medicalrecords.dao.MedicalRecordDao;
import com.bashizip.medicalrecords.model.MedicalRecord;
import spark.Service;

/**
 *
 * @author Patrick
 */
public class MedicalRecordEndpoint implements EndpointBuilder {

    MedicalRecordDao dao = new MedicalRecordDao();

    @Override
    public void configure(Service spark, String basePath) {

        /**
         * GET all medical records
         */
        spark.get(basePath + "/emr", (req, res) -> {
            return dao.findAll();
        }, new JsonTransformer());

        /**
         * post new medical record
         */
        spark.post(basePath + "/emr", "application/json", (req, res) -> {

            String body = req.body();
            MedicalRecord userBean = JsonTransformer.getObjectMapper().readValue(body, MedicalRecord.class);

            try {
                dao.create(userBean);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return userBean;
        }, new JsonTransformer());

        spark.after((request, response) -> response.type("application/json"));
    }
}
