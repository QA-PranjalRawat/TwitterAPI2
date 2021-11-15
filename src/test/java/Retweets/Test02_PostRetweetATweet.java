package Retweets;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_PostRetweetATweet extends ResponseFile {

    String tweetId = "1457937214273327104";

    @Test
    public void postRetweetATweet() throws IOException {
        RestAssured.baseURI = baseUrl;

        JSONObject request = new JSONObject();
        request.put("tweet_id",tweetId);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type","application/json").
                post("users/"+userId+"/retweets").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
