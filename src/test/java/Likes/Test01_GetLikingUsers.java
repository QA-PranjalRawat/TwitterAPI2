package Likes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import Response.ResponseFile;

import static io.restassured.RestAssured.given;

public class Test01_GetLikingUsers extends ResponseFile {

    String tweetId = "1354143047324299264";

    @Test
    public void getStream() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                when().
                get("tweets/"+tweetId+"/liking_users").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());

    }
}
