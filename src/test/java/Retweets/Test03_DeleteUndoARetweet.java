package Retweets;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test03_DeleteUndoARetweet extends ResponseFile {
    String tweetId = "1457937214273327104";

    @Test
    public void deleteUndoARetweet() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("users/"+userId+"/retweets/"+tweetId).
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
