package com.configuration;

//import com.Exception;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utils {

    @Value("${registerAPI.rest.url}")
    String registerAPIUrl;

    @Value("${fetchWeatherDetailsAPI.rest.url}")
    String fetchWeatherDetailsAPIUrl;

    @Value("${petStore.rest.url}")
    String petStoreAPIUrl;


    public String getAPIUrl(String APIName)throws Exception
    {
         if (APIName.equalsIgnoreCase("register"))
         {
             return registerAPIUrl;
         }
         else if(APIName.equalsIgnoreCase("fetchWeatherDetails"))
         {
             return fetchWeatherDetailsAPIUrl;
         }
         else if(APIName.equalsIgnoreCase("petStore"))
         {
             return petStoreAPIUrl ;
         }
         else
         {
             throw new Exception("Invalid API Name");
         }

    }
}
