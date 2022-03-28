package com.json.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ObjectMapperConvertJson {
    public  <T> List<T> getDesObject(String s, Class<T> clazz) {
        T arr=null ;
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //SimpleModule module=new SimpleModule("ObjectMapperDeSerialization");
       // module.addDeserializer(Date.class,new ObjectMapperDeSerialization());
        //mapper.registerModule(module);
        mapper.registerModule(new JodaModule());
        try {
            arr=mapper.readValue(s,clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Arrays.asList(arr);
    }
    public  <T> String getSerJson(T obj)
    {
        String json=null;
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //SimpleModule module=new SimpleModule("ObjectMapperSerialization");
        //module.addSerializer(Date.class,new ObjectMapperSerialization());
        //mapper.registerModule(module);
        mapper.registerModule(new JodaModule());
        try {
             json=mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
