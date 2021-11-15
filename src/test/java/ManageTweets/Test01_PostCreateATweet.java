package ManageTweets;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test01_PostCreateATweet extends ResponseFile {
    String tweetBody = "Hi There this is a second API Testing tweet done using RestAssured in JAVA";

    @Test
    public void postCreateATweet() throws IOException {
        RestAssured.baseURI = baseUrl;

        JSONObject request = new JSONObject();
        request.put("text",tweetBody);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type","application/json").
                post("tweets").
                then().
                assertThat().statusCode(201).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
