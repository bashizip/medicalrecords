package com.bashizip.medicalrecords.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Service;

/**
 *
 * @author bash
 */
public class RestContext {

    private static final Logger LOG = LoggerFactory.getLogger(RestContext.class);
    
    private final Service spark;
    private final String basePath;

    public RestContext(int port, String basePath) {
        this.basePath = basePath;
        spark = Service.ignite().port(port);
    }

    public void addEndpoint(EndpointBuilder endpoint) {
        endpoint.configure(spark, basePath);
        LOG.info("REST endpoints registered for {}.", endpoint.getClass().getSimpleName());
    }

    public void enableCors() {

        spark.options("/*", (req, res) -> {
            String accessControlRequestHeaders = req.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                res.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = req.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                res.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        spark.before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "*");
            res.header("Access-Control-Allow-Credentials", "true");
            res.header("Access-Control-Max-Age", "43200");
            res.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            //res.type("application/json");
        });

        LOG.info("CORS support enabled.");
    }

}
