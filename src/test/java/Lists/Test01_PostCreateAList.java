package Lists;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test01_PostCreateAList extends ResponseFile {
    String listName = "My New LIst";
    String listDescription = "This is the description of my new list";
    boolean listPrivate = false;

    @Test
    public void postCreateAList() throws IOException {
        RestAssured.baseURI = baseUrl;

        JSONObject request = new JSONObject();
        request.put("name",listName);
        request.put("description",listDescription);
        request.put("private",listPrivate);

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                body(request.toJSONString()).
                when().
                header("Content-Type","application/json").
                post("lists").
                then().assertThat().statusCode(201).log().all().
                extract().response();

        responseMethod(response.asString());

    }

}
