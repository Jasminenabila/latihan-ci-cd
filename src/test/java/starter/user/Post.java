package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Post {
    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set POST api endpoints")
    public String setPostApiEndpoint() {
        return url + "posts";
    }

    @Step("I send POST HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Harry Potter And the prisoner of Azkaban");
        requestBody.put("body", "Adventure, Friendship");
        requestBody.put("userId", "103");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpoint());
    }

    @Step("I receive valid HTTP response code 201")
    public void receiveHttpResponseCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for new user")
    public void validateDatanewUser() {
        Response response = SerenityRest.lastResponse();
        String title = response.getBody().jsonPath().get("title");
        String body = response.getBody().jsonPath().get("body");
        String userId = response.getBody().jsonPath().get("userId");
        Assert.assertEquals(title, "Harry Potter And the prisoner of Azkaban");
        Assert.assertEquals(body, "Adventure, Friendship");
        Assert.assertEquals(userId, "103");
    }
}
