package starter.user;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;


import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PutFailed {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("user set PUT endpoints invalid userid not found is failed")
    public String setPutUserIdNotFound() {
        return url + "posts/1000";
    }

    @Step("user send PUT HTTP request update userid not found is failed")
    public void sendPutUserIdNotFound() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Tinkerbell");
        requestBody.put("body", "Adventure, Friendship, Love");
        requestBody.put("userId", "104");
        requestBody.put("id", "100");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).put(setPutUserIdNotFound());
    }

    @Step("user receive internal server error HTTP response code 500 is failed")
    public void getInternalServerError() {
        restAssuredThat(response -> response.statusCode(500));
    }
}
