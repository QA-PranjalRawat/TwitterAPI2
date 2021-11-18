package FilteredStream;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_GetRetrieveRules extends ResponseFile {

    @Test
    public void getRetrieveRules() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth2(bearerToken).
                when().
                get("tweets/search/stream/rules").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
