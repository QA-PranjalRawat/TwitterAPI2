package UserLookUp;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_GetUsersById extends ResponseFile {

    String userIds = "812159128672096256,1362277459194904577,1267416363896901634,163198473";

    @Test
    public void getUsersById() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                queryParam("ids",userIds).
                when().
                get("users").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
