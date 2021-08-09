/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bashizip.medicalrecords;

import com.bashizip.medicalrecords.service.LoggingEndPoint;
import com.bashizip.medicalrecords.service.MedicalRecordEndpoint;
import com.bashizip.medicalrecords.service.RestContext;

/**
 *
 * @author Patrick
 */
public class Main {

    public static void main(String[] args) {
        RestContext context = new RestContext(8484, "/api/1.0/emr/");
        context.enableCors(); //only needed for web clients
        context.addEndpoint(new LoggingEndPoint());
        context.addEndpoint(new MedicalRecordEndpoint());
    }
}
