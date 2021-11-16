package Lists;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test05_PutUpdateAList extends ResponseFile {

    String listId = "1460127448629067777";

    String newName = "New Updated Name";
    String newDesc = "This is new description";
    boolean newPrivate = false;

    @Test
    public void putUpdateAList() throws IOException {
        RestAssured.baseURI = baseUrl;

        JSONObject request = new JSONObject();
        request.put("name",newName);
        request.put("description",newDesc);
        request.put("private",newPrivate);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type","application/json").
                put("lists/"+listId).
                then().assertThat().statusCode(200).log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
