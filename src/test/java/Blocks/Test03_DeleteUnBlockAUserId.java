package Blocks;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test03_DeleteUnBlockAUserId extends ResponseFile {
    String targetUserId = "22870427";

    @Test
    public void deleteUnBlockAUserId() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("users/"+userId+"/blocking/"+targetUserId).
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
