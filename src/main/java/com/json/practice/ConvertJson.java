package com.json.practice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.json.practice2.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ConvertJson {
    /**
     *
     * @param file where json string is store
     * @return  json string of mobile is returned
     */
    public  String getJsonString(File file)
    {
        List<String> lines=null;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String JsonString = String.join("\n", lines );
        return JsonString;
    }

    /**
     *
     * @param fileName file from data read
     * @param classLoader classloader object to read file URL
     * @return file object of URL found
     */
    public File getResourceFile(String fileName,ClassLoader classLoader)
    {
        URL resource = classLoader.getResource(fileName);
        File file=null;
        try {
            file=new File(resource.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     *
     * @param obj object of T class
     * @param <T> generic class
     * @return generic string class object
     */
    public  <T> String getSerJson(T obj)
    {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .create();
        String json=gson.toJson(obj);
        return json;
    }

    /**
     *
     * @param s jsonString
     * @param clazz generic class T  object
     * @param <T> list of generic class object
     * @return
     */
    public  <T> List<T> getDesObject(String s, Class<T> clazz) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .create();
        T arr = gson.fromJson(s, clazz);
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {

        ConvertJson convertJson=new ConvertJson();

        //MobilePhone class
        String mobileFile="mobiledata.json";
        ClassLoader classLoader = ConvertJson.class.getClassLoader();
       /*File mobile=convertJson.getResourceFile(mobileFile,classLoader);
        String mobileJsonString=convertJson.getJsonString(mobile);

        System.out.println("*********************Serialization and Deserialization  through GSON Class ****************");


        //2 converting json String to java object
        MobilePhone mobilePhone=convertJson.getDesObject(mobileJsonString,MobilePhone.class).get(0);

        //1 converting java object to jsonString.
        String mobileSerJsonString = convertJson.getSerJson(mobilePhone);

        System.out.println(mobileSerJsonString.equals(mobileJsonString));
        System.out.println(mobileJsonString);
        System.out.println(mobileSerJsonString);
        System.out.println(mobileJsonString.length()+" "+mobileSerJsonString.length());*/



        //DataSet class
        String fileName="data.json";
        File file=convertJson.getResourceFile(fileName,classLoader);
        String JsonString=convertJson.getJsonString(file);
        /*DataSet dataSet= convertJson.getDesObject(JsonString, DataSet.class).get(0);
        System.out.println(dataSet.getData().get(0).getCreated());
        System.out.println(dataSet.getData().get(0).getUpdated());
        String datasetJson=convertJson.getSerJson(dataSet);
        System.out.println(datasetJson);
        System.out.println(JsonString);
        System.out.println(datasetJson.equals(JsonString));*/


        System.out.println("\n \n \n");
        System.out.println("*********************Serialization and Deserialization  through ObjectMapper Class ****************");

        ObjectMapperConvertJson objectMapperConvertJson=new ObjectMapperConvertJson();
        //MobilePhone mobilePhone1=objectMapperConvertJson.getDesObject(mobileJsonString,MobilePhone.class).get(0);
        //String mobileSerJsonString1=objectMapperConvertJson.getSerJson(mobilePhone1);
        //System.out.println(mobileSerJsonString1);
        //System.out.println(mobileJsonString);
        //System.out.println(mobileSerJsonString1.equals(mobileJsonString));

        DataSet dataSet1=objectMapperConvertJson.getDesObject(JsonString,DataSet.class).get(0);
        String datasetJson2=objectMapperConvertJson.getSerJson(dataSet1);
        System.out.println(JsonString);
        System.out.println(datasetJson2);
        System.out.println(datasetJson2.equals(JsonString));
        System.out.println(dataSet1);

    }
}
