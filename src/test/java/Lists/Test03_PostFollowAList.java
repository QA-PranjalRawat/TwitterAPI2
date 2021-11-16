package Lists;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test03_PostFollowAList extends ResponseFile {
    String listId = "1460127448629067777";

    @Test
    public void postFollowAList() throws IOException {
        RestAssured.baseURI = baseUrl;
        JSONObject request = new JSONObject();
        request.put("list_id",listId);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type","application/json").
                post("users/"+userId+"/followed_lists").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
