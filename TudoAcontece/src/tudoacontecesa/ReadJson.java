/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudoacontecesa;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author DMORAIS
 */
public class ReadJson {
    //Passa de um formato para outro, através do Parser
    public static void main(String[] args){
    
    JSONParser parser = new JSONParser();
    
    // try/catch block para se usar algumas excepções
    
   try
   {
       Object obj = parser.parse(new FileReader("myJSON.json"));
       JSONObject jsonObject = (JSONObject) obj;
       String name = (String) jsonObject.get("name");
       System.out.println("Name is: " + name);
       
       String location = (String) jsonObject.get("location");
       System.out.println("Location is: " + location);
       
       //loop array
       JSONArray coursesAarray = (JSONArray) jsonObject.get("courses");
       //Use Java class that allows to look through a collection
      
       
   }
    
    catch(FileNotFoundException e){
        e.printStackTrace();
    }
    catch(IOException e){
    }
   
    catch(ParseException e){
    
   }
    catch(Exception e){
       }
    }
}