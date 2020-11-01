package com.configuration;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.IOException;

@Configuration
public class JSONHandler {

   JSONObject jsonObject;
   public final String JSONFilePath="src/test/resources/requestData/";

    public JSONObject readJSONFile(String JSONFileName)
   {

       Object obj;
      try {
          obj = new JSONParser().parse(new FileReader(JSONFilePath + JSONFileName + ".json"));
          jsonObject=(JSONObject) obj;
      }
      catch (IOException e)
      {
          e.printStackTrace();
      }
      catch (ParseException p)
      {
          p.printStackTrace();
      }

      return jsonObject;

   }


}
