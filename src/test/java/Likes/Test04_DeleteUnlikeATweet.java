package Likes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Response.ResponseFile;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test04_DeleteUnlikeATweet extends ResponseFile{

    String tweetId = "1457937214273327104";

    @Test
    public void deleteUnlikeATweet() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("/users/"+userId+"/likes/"+tweetId).
                then().statusCode(200)
                .log().all().extract().response();

        responseMethod(response.asString());
    }
}
