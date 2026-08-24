package apitests;

import api.BaseApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletePostTest extends BaseApiTest {

    @Test
    public void verifyDeletePostTest() {

        given()

                .when()
                .delete("/posts/1")

                .then()
                .statusCode(200)
                .log().all();

    }
}
