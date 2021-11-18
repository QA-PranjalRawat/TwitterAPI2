package FilteredStream;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test03_DeleteRuleById extends ResponseFile {

    @Test
    public void deleteRuleById() throws IOException {
        RestAssured.baseURI = baseUrl;

        String reuqestBody = "{\n" +
                "    \"delete\": {\n" +
                "        \"ids\": [\n" +
                "            \"1460914627726897158\"\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        Response response = given().
                auth().oauth2(bearerToken).
                body(reuqestBody).
                when().
                header("Content-type", "application/json").
                post("tweets/search/stream/rules").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
