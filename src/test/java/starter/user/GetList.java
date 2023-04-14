package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetList {
    protected static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set GET api endpoints list")
    public String setApiEndpointGetList() {
        return url + "posts";
    }

    @Step("I send GET HTTP request list")
    public void sendGetListHttpRequest() {
        SerenityRest.given().get(setApiEndpointGetList());
    }

    @Step("I receive valid HTTP response code 200 list")
    public void validateListHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for list user")
    public void validateDataListUser() {
        Response response = SerenityRest.lastResponse();
        int id = response.getBody().jsonPath().get("[0].userId");
        String title = response.getBody().jsonPath().get("[0].title");
        Assert.assertEquals(id,1);
        Assert.assertEquals(title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

    @Step("user set GET endpoints get data with id is failed")
    public String setGetDetailEndpointFailed(){
        return url + "posts/00";
    }

    @Step("user send GET HTTP request is failed")
    public void getHttpDetailIdRequestFailed(){
        SerenityRest.given().when().get(setGetDetailEndpointFailed());
    }

    @Step("user receive valid HTTP response code 404 is failed")
    public void HTTPResponse404GetDetailFailed(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("user receive invalid data is failed")
    public void invalidDataGetDetailID(){
        Response response = SerenityRest.lastResponse();
        System.out.println(response);
    }

}
