package FilteredStream;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test01_PostAddRules extends ResponseFile {


    @Test
    public void postAddRules() throws IOException {
        RestAssured.baseURI = baseUrl;

        String requestBody ="{\n" +
               " \"add\": [ \n"+
        "{\n" +
              " \"value\": \"My Rule Value\",\n" +
              "  \"tag\": \"My Rule\" \n" +
        "}\n"+
    "]\n "+
"}";


        JSONObject request = new JSONObject();

        Response response = given().
                auth().oauth2(bearerToken).
                body(requestBody).
                when().
                header("Content-type", "application/json").
                post("tweets/search/stream/rules").
                then().log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
