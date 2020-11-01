package com.configuration;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class HeaderValues {

    private  static Headers headers;
    static List<Header> headerList=new ArrayList<>();
    static
    {
        //Header header1=new Header("Content-Type","application/json");
        Header header1=new Header("content-type","application/json");
       // Header header2=new Header("Content-Encoding","gzip");
        //Header header3=new Header("Server","nginx");

        headerList.add(header1);
        //headerList.add(header2);
     //   headerList.add(header3);

        headers=new Headers(headerList);


    }

    public static Headers passingHeaders()
    {
        return  headers;
    }

}
