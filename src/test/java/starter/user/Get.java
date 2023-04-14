package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Get {

    protected static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set GET api endpoints")
    public String setApiEndpoint() {
        return url + "posts/1";
    }

    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for detail user")
    public void validateDataDetailUser() {
        Response response = SerenityRest.lastResponse();
        int id = response.getBody().jsonPath().get("userId");
        String title = response.getBody().jsonPath().get("title");
        Assert.assertEquals(id,1);
        Assert.assertEquals(title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }

}
