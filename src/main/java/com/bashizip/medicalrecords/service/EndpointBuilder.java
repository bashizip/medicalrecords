/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bashizip.medicalrecords.service;

import spark.Service;

/**
 *
 * @author bash
 */
public interface EndpointBuilder {
  void configure(Service spark, String basePath);
}
