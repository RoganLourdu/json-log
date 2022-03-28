package com.company;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Products {

    public static void main(String[] args) {
        final Logger logger=Logger.getLogger(Products.class);
        JSONParser jsonParser=new JSONParser();
        String path="/home/rogan-zstk272/IdeaProjects/example/src/com/company/log4j.properties";
        PropertyConfigurator.configure(path);
        try{
            FileReader reader=new FileReader("/home/rogan-zstk272/IdeaProjects/example/src/products.json");
            Object obj=jsonParser.parse(reader);
            JSONObject jobj=(JSONObject) obj;
            JSONArray productlist=(JSONArray) jobj.get("products");
            for(int i=0;i<productlist.size();i++) {
                JSONObject jsonobj=(JSONObject) productlist.get(i);
                String id=String.valueOf(jsonobj.get("prodId"));
                String name= String.valueOf(jsonobj.get("prodName"));
                String price= String.valueOf(jsonobj.get("Price"));
                System.out.println("Id : "+id+"\tName : "+name+"\tPrice : "+price);
            }
        }
        catch (FileNotFoundException e){
            logger.error("File not founted");
        }
        catch (IOException e){
            logger.error("IO Exception occured");
        }
        catch (ParseException e){
            logger.error("Fail to reload json file");
        }
        catch (Exception e){
            logger.debug("Some thing wrong");
        }
      finally {
            System.out.println("\nall execute");
        }
    }
}
