/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bashizip.medicalrecords.dao;

import io.jsondb.JsonDBTemplate;
import spark.Spark;

/**
 *
 * @author Patrick
 */
public class Database {

    JsonDBTemplate jsonDBTemplate;

    public Database() {
        init();
    }

    public JsonDBTemplate getJsonDBTemplate() {

        return jsonDBTemplate;
    }

    private void init() {
        String dbFilesLocation = "D:\\medicalrecords";

//Java package name where POJO's are present
        String baseScanPackage = "com.bashizip.medicalrecords.model";

//Optionally a Cipher object if you need Encryption
        //    ICipher cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");
        jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage);
    }
}
