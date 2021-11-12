package UserLookUp;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test01_GetUserById extends ResponseFile {
    String userId = "812159128672096256";

    @Test
    public void getUserById() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                when().
                get("users/"+userId).
                then().assertThat().statusCode(200).
                log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
