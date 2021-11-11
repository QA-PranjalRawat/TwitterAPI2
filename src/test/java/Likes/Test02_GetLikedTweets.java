package Likes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import Response.ResponseFile;

import static io.restassured.RestAssured.given;

public class Test02_GetLikedTweets extends ResponseFile{
    String userId = "2244994945";

    @Test
    public void getLikedTweets() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                queryParam("max_results","5").
                when().
                get("users/"+userId+"/liked_tweets").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
