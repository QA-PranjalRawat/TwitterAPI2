package UserLookUp;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test04_GetUsersByUserName extends ResponseFile {

    String userNames = "Pranjalrawat78,BonkeyDapp,verograuert,NeuralYorker";

    @Test
    public void getUsersByUserName() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                queryParam("usernames",userNames).
                when().
                get("users/by").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
