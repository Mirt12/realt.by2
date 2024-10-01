package test.api;


import main.api.PageObjectForLogin;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


public class RestApiLoginTests {

    @Test
    public void validUserCanLoginTest() {
        PageObjectForLogin po = new PageObjectForLogin();
        given().headers(po.getRequestHeaders())
                .queryParams(po.getQueryParams("Mirt12@yandex.ru", "testPass01!"))
                .when().post(po.endpoint)
                .then()
                .statusCode(200)
                .body(containsString("token"));
    }

}
