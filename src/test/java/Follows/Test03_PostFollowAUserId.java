package Follows;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test03_PostFollowAUserId extends ResponseFile {

    String targetUserId = "44196397";

    @Test
    public void postFollowAUserId() throws IOException {
        RestAssured.baseURI = baseUrl;

        JSONObject request = new JSONObject();
        request.put("target_user_id",targetUserId);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type", "application/json").
                post("users/"+userId+"/following").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
