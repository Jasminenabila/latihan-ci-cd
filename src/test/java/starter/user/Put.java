package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Put {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints() {
        return url + "posts/1";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Harry Potter And jasmine");
        requestBody.put("body", "Adventure, Friendship, Love");
        requestBody.put("userId", "104");
        requestBody.put("id", "1");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).put(setPutApiEndpoints());
    }

    @Step("I receive valid PUT HTTP response code 200")
    public void getHttprequestMethodPut() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for updated user")
    public void validateUpdateUser() {
        Response response = SerenityRest.lastResponse();
        String title = response.getBody().jsonPath().get("title");
        String body = response.getBody().jsonPath().get("body");
        String userId = response.getBody().jsonPath().get("userId");
        int id = response.getBody().jsonPath().get("id");
        Assert.assertEquals(title, "Harry Potter And jasmine");
        Assert.assertEquals(body, "Adventure, Friendship, Love");
        Assert.assertEquals(userId, "104");
        Assert.assertEquals(id,1);
    }
}
