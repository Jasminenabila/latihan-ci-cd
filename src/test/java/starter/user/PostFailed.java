package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostFailed {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("user set POST endpoints invalid submit data is failed")
    public String setPostApiEndpointInvalidURL() {
        return url + "posts";
    }

    @Step("user send POST HTTP request submit data is failed")
    public void sendPostData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "");
        requestBody.put("body", "");
        requestBody.put("userId", "");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(setPostApiEndpointInvalidURL());
    }

    @Step("user receive valid data submit post HTTP response code 404 is failed")
    public void receiveHttpRequestPostInvalid() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("user receive invalid response body is failed")
    public void responseBodyEmptyFailed() {
        Response response = SerenityRest.lastResponse();
        String title = response.getBody().jsonPath().get("title");
        String body = response.getBody().jsonPath().get("body");
        String userId = response.getBody().jsonPath().get("userId");
        Assert.assertEquals(title, "");
        Assert.assertEquals(body, "");
        Assert.assertEquals(userId, "");
    }
}
