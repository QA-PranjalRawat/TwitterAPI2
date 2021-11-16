package Lists;

import Response.ResponseFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test09_DeleteDeleteAList extends ResponseFile {

    String listId = "1460258581823975425";

    @Test
    public void deleteAList() throws IOException {
        RestAssured.baseURI = baseUrl;

        Response response = given().
                auth().oauth(consumerKey,consumerSecret,accessToken,tokenSecret).
                when().
                delete("lists/"+listId).
                then().log().all().
                extract().response();

        responseMethod(response.asString());
    }
}
