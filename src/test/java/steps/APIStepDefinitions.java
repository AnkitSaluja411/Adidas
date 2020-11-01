package steps;


//import com.CustomException;
import com.AbstractCucumberTest;
import com.configuration.RestImpl;
//import com.test.AbstractCucumberTest;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.util.List;

@ContextConfiguration
public class APIStepDefinitions extends AbstractCucumberTest {

    RequestSpecification httpRequest;
    Response response;

    @Autowired
    RestImpl restApi;


    @Given("I prepare the GET request for \"([^\"]*)\" API")
    public void iprepareTheGETRequestForAPI(String APIName) {
        try {
            httpRequest = restApi.settingGETRequestForAPI(APIName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I hit \"([^\"]*)\" api")
    public void userHitApi(String apiName) {

        response = httpRequest.log().all().get("/pet/findByStatus?status=available");
    }

    @Then("I validate list of pets with available status received in response")
    public void validateListOfPetsWithAvailableStatusReceivedInResponse() {

        ResponseBody responseBody = response.getBody();
        System.out.println(responseBody.prettyPrint());

        List<String> jsonResponse = response.jsonPath().getList("status");
        for (int i = 0; i < jsonResponse.size(); i++) {
            Assert.assertEquals("Status not matching", "available", jsonResponse.get(i));
        }
    }

    @Given("I prepare the POST request for \"([^\"]*)\" API")
    public void iprepareThePOSTRequestForAPI(String APIName) {
        try {
            httpRequest = restApi.settingPostRequestForAPI(APIName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I hit post addNewPet api")
    public void userHitPostAddNewPetApi() {
        response = httpRequest.post("/pet");
    }

    @Then("I validate new pet added succesfully")
    public void validateNewPetAddedSuccesfully() {

        System.out.println(response.getStatusCode());
        Assert.assertEquals("New pet not added ..", 200, response.statusCode());
    }

    @Given("I prepare the PUT request for \"([^\"]*)\" API")
    public void prepareThePUTRequestForAPI(String APIName) {
        try {
            httpRequest = restApi.settingPUTRequestForAPI(APIName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^I hit put updatePetStatus API$")
    public void userHitPutUpdatePetStatusAPI() throws Throwable {

        response = httpRequest.log().all().put("/pet");
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("^I verify request is successful$")
    public void iVerifyRequestIsSuccessful() throws Throwable {
        Assert.assertEquals(200, response.getStatusCode());
    }
}


