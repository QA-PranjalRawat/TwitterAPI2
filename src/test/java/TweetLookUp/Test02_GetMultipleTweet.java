package TweetLookUp;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_GetMultipleTweet extends ResponseFile {
    String tweetIds = "1457937214273327104,1354143047324299264";

    @Test
    public void getMultipleTweet() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                queryParam("ids",tweetIds).
                when().
                get("tweets").
                then().assertThat().statusCode(200)
                .log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
