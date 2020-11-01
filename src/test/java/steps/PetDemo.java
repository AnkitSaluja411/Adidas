package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

public class PetDemo {

    public static void main(String args[])
    {
        String baseUrl = "https://petstore.swagger.io/v2";

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Response response = request.get("/pet/findByStatus?status=available");
       // System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

        //String jsonString = response.asString();
        List<String> jsonResponse=response.jsonPath().getList("status");
        for (int i=0;i<jsonResponse.size();i++) {
            //System.out.println(jsonResponse.get(i));
            Assert.assertEquals("Status not matching", "available", jsonResponse.get(i));
        }
    }
}
