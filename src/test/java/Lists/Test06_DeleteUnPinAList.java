package Lists;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test06_DeleteUnPinAList extends ResponseFile {

    String listId = "1460127448629067777";

    @Test
    public void  deleteUnPinAList() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("lists/"+userId+"/pinned_lists/"+listId).
                then().log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
