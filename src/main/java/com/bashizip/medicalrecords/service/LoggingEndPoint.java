package com.bashizip.medicalrecords.service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.slf4j.LoggerFactory;
import spark.Service;

/**
 *
 * @author bash
 */
public class LoggingEndPoint implements EndpointBuilder {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RestContext.class);

    @Override
    public void configure(Service spark, String basePath) {

        spark.get(basePath + "/logs", "text/plain", (req, res) -> {

            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream("logs/app.log");
            } catch (FileNotFoundException ex) {
                LOG.error(ex.getMessage());
                ex.printStackTrace();
            }
            return inputStream;

        });

        spark.get("/", (req, res) -> "Hello from medical records backend");

    }

}
