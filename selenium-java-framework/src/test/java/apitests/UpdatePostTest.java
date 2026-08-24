package apitests;

import api.BaseApiTest;
import apimodel.PostRequest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdatePostTest extends BaseApiTest {

    @Test
    public void verifyUpdatePost(){

        PostRequest requestBody = new PostRequest("Updated QA Automation",
                "Updated REST Assured Portfolio Test",
                1);


        given()
                .contentType("application/json")
                .body(requestBody)

                .when()
                .put("/posts/1")

                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", equalTo("Updated QA Automation"))
                .body("body", equalTo("Updated REST Assured Portfolio Test"))
                .body("userId", equalTo(1))
                .log().all();


    }
}
