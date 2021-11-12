package Follows;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_GetUsersAUserIdIsFollowing extends ResponseFile {

    String userId = "1267416363896901634";

    @Test
    public void getUsersAUserIdIsFollowing() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                queryParam("max_results","10").
                when().
                get("users/"+userId+"/following").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
