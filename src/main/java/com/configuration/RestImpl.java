package com.configuration;

//import com.Exception;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import io.restassured.specification.RequestSpecification;

@Component
public class RestImpl {

    RequestSpecification httpRequest;
    @Autowired
    Utils utils;
    @Autowired
    HeaderValues headerValues;
    @Autowired
    JSONHandler jsonHandler;


    public RequestSpecification settingPostRequestForAPI(String APIName)throws Exception  {
      // System.out.println(registerAPI);

        try {
            RestAssured.baseURI = utils.getAPIUrl(APIName);
            // System.out.println(RestAssured.baseURI);
            httpRequest = RestAssured.given().headers(headerValues.passingHeaders()).body(jsonHandler.readJSONFile(APIName).toString());
            return httpRequest;
        }
        catch (Exception e)
        {
           throw new Exception(e.getMessage());
        }

    }

    public RequestSpecification settingGETRequestForAPI(String APIName)throws Exception
    {
        try{
            RestAssured.baseURI=utils.getAPIUrl(APIName);
            httpRequest=RestAssured.given().headers(headerValues.passingHeaders());
            return httpRequest;
        }
        catch (Exception c)
        {
            throw new Exception(c.getMessage());
        }

    }


    public RequestSpecification settingPUTRequestForAPI(String APIName)throws Exception
    {
        try {
            RestAssured.baseURI=utils.getAPIUrl(APIName);
//            httpRequest=RestAssured.given().headers(headerValues.passingHeaders());
            httpRequest = RestAssured.given().headers(headerValues.passingHeaders()).body(jsonHandler.readJSONFile(APIName).toString());
            return httpRequest;
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }




}
