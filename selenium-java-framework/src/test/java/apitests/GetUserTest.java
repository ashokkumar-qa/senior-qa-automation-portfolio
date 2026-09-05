package apitests;

import api.BaseApiTest;
import apimodel.PostResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserTest extends BaseApiTest {

    @Test
    public void verifyGetUser() {

        Response response =
                given()

                .when()
                .get("/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200);

        PostResponse postResponse =
                response.as(PostResponse.class);

        Assert.assertEquals(postResponse.getUserId(), 1);
        Assert.assertEquals(postResponse.getId(), 1);

        Assert.assertEquals(postResponse.getTitle(),
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");

    }
}
