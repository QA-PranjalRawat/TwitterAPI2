package SearchTweets;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test01_GetRecentSearch extends ResponseFile {
    String query = "API Testing";

    @Test
    public void getRecentSearch() throws IOException {
        RestAssured.baseURI = baseUrl;
        Response response = given().
                auth().oauth2(bearerToken).
                queryParam("query",query).
                when().
                get("tweets/search/recent").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
