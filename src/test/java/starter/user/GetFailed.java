package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetFailed {

    protected static String url = "https://jsonplaceholder.typicode.com/";
    @Step("user set GET endpoints failed")
    public String setGetEndpointsFailed(){
        return url + "postzzz12345";
    }
    @Step("user send GET HTTP request")
    public void getHttpRequestFailed(){
        SerenityRest.given().when().get(setGetEndpointsFailed());
    }
    @Step("user receive valid HTTP response code 404")
    public void HTTPresponse404(){
        restAssuredThat(response -> response.statusCode(404));

    }
    @Step("user receive invalid data")
    public void invalidData(){
        Response response = SerenityRest.lastResponse();
        System.out.println(response);

    }
}
