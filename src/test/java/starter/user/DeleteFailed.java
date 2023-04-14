package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteFailed {

    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("user set DELETE endpoints invalid url is failed")
    public String setDeleteInvalidURL() {
        return url + "possttt";
    }

    @Step("user send DELETE HTTP request invalid url is failed")
    public void sendDELETEInvalidURL() {
        SerenityRest.given().delete(setDeleteInvalidURL());
    }

    @Step("user receive response HTTP response code 404 method DELETE is failed")
    public void getHttpRequestMethodDelete() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
