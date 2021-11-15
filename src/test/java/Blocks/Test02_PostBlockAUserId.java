package Blocks;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test02_PostBlockAUserId extends ResponseFile {

    String targetUserId = "22870427";

    @Test
    public void postBlockAUserId() throws IOException {
        RestAssured.baseURI = baseUrl;

        JSONObject request = new JSONObject();
        request.put("target_user_id",targetUserId);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type","application/json").
                post("users/"+userId+"/blocking").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
