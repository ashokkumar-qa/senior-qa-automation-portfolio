package apitests;

import api.BaseApiTest;
import apimodel.PostRequest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class CreatePostTest extends BaseApiTest {

    @Test
    public void verifyCreatePost(){

        PostRequest requestBody = new PostRequest(
                "QA Automation",
                "REST Assured Portfolio Test",
                1);

        given()
                .contentType("application/json")
                .body(requestBody)

                .when()
                .post("posts")

                .then()
                    .statusCode(201)
                    .body("title", equalTo("QA Automation"))
                    .body("body", equalTo("REST Assured Portfolio Test"))
                    .body("userId", equalTo(1))
                .body("id", notNullValue())
                    .log().all();

    }

}
