package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetFailedDetailID {

    protected static String url = "https://jsonplaceholder.typicode.com/";
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
