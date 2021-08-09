package com.bashizip.medicalrecords.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import spark.ResponseTransformer;

/**
 *
 * @author bash
 */
public class JsonTransformer implements ResponseTransformer {

 
    public static ObjectMapper getObjectMapper() {
         ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z"));
        return objectMapper;
    }
   
   

    @Override
    public String render(Object model) {
        String json = null;
    
        try {
            json = getObjectMapper().writeValueAsString(model);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
