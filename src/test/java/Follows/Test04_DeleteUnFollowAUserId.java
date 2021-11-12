package Follows;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test04_DeleteUnFollowAUserId extends ResponseFile {

    String targetUserId = "44196397";

    @Test
    public void deleteUnFollowAUserId() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("/users/"+userId+"/following/"+targetUserId).
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
