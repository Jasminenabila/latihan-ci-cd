package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Delete {
    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set DELETE api endpoints")
    public String setDeleteApiEndpoins() {
        return url + "posts/1";
    }

    @Step("I send DELETE HTTP request")
    public void sendDeleteHttpRequest() {
        SerenityRest.given().delete(setDeleteApiEndpoins());
    }
    @Step("I receive valid delete HTTP response code 200")
    public void validateDeleteStatus200(){
        restAssuredThat(response -> response.statusCode(200));
    }
}
