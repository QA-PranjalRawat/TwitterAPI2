package ManageTweets;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_DeleteDeleteATweet extends ResponseFile {
    String tweetId = "1460112038953304067";

    @Test
    public void deleteDeleteATweet() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("tweets/"+tweetId).
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
