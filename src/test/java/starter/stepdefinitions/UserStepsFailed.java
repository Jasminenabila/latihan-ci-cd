package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.*;

public class UserStepsFailed {

    @Steps
    GetFailed gf;

    @Steps
    GetFailedDetailID gdf;

    @Steps
    PostFailed pf;

    @Steps
    PutFailed putf;

    @Steps
    DeleteFailed df;

    @Given("user set GET endpoints failed")
    public void setGetEndpointsFailed(){
        gf.setGetEndpointsFailed();

    }
    @When("user send GET HTTP request")
    public void getHttpRequestFailed(){
        gf.getHttpRequestFailed();

    }
    @Then("user receive valid HTTP response code 404")
    public void HTTPresponse404(){
        gf.HTTPresponse404();

    }
    @And("user receive invalid data")
    public void invalidData(){
        gf.invalidData();
    }

    @Given("user set GET endpoints get data with id is failed")
    public void setGetDetailIDEndpoint(){
        gdf.setGetDetailEndpointFailed();
    }

    @When("user send GET HTTP request is failed")
    public void getHttpRequestDetailIDFailed(){
        gdf.getHttpDetailIdRequestFailed();
    }

    @Then("user receive valid HTTP response code 404 is failed")
    public void HttpResponseDetailID404(){
        gdf.HTTPResponse404GetDetailFailed();
    }

    @And("user receive invalid data is failed")
    public void invalidDataGetDetail(){
        gdf.invalidDataGetDetailID();
    }

    @Given("user set POST endpoints invalid submit data is failed")
    public void setPostRequestInvalidUrl(){
        pf.setPostApiEndpointInvalidURL();
    }

    @When("user send POST HTTP request submit data is failed")
    public void getHTTPRequestSubmitData(){
        pf.sendPostData();
    }

    @Then("user receive valid data submit post HTTP response code 404 is failed")
    public void getHttprequestSubmitFailed(){
        pf.receiveHttpRequestPostInvalid();
    }

    @And("user receive invalid response body should be failed")
    public void responseBodyEmpty(){
        pf.responseBodyEmptyFailed();
    }

    @Given("user set PUT endpoints invalid userid not found is failed")
    public void userIdPutNotFound(){
        putf.setPutUserIdNotFound();
    }

    @When("user send PUT HTTP request update userid not found is failed")
    public void sendUserPutIdNotFound(){
        putf.sendPutUserIdNotFound();
    }

    @Then("user receive internal server error HTTP response code 500 is failed")
    public void getHttpRequest500(){
        putf.getInternalServerError();
    }

    @Given("user set DELETE endpoints invalid url is failed")
    public void setDeleteInvalidUrl(){
        df.setDeleteInvalidURL();
    }

    @When("user send DELETE HTTP request invalid url is failed")
    public void sendDeleteURLInvalid(){
        df.sendDELETEInvalidURL();
    }

    @Then("user receive response HTTP response code 404 method DELETE is failed")
    public void getRequestCodeMethodDelete(){
        df.getHttpRequestMethodDelete();
    }
}
