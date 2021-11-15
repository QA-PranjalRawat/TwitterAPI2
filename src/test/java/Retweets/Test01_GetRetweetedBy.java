package Retweets;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test01_GetRetweetedBy extends ResponseFile {
    String tweetId = "1457937214273327104";

    @Test
    public void getRetweetedBy() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                when().
                get("tweets/"+tweetId+"/retweeted_by").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
