package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.payloads.AuthRequestPayload;

import static io.restassured.RestAssured.given;



public class AuthUtils {

    public static void main(String[] args) {
        System.out.println(generateToken());
    }

    public static String generateToken(){
        AuthRequestPayload authRequestPayload = new AuthRequestPayload("John.123",
                                                                    true,
                                                                    "john_doe");

        String API_URL = "https://www.gmibank.com/api/authenticate";

        Response response = given().
                contentType(ContentType.JSON).
                body(authRequestPayload).when().post(API_URL);
        //response.prettyPrint();

        return response.jsonPath().getString("id_token");
    }

}
