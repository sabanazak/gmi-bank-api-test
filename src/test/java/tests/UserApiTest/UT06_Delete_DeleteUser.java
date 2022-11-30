package tests.UserApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static tests.UserApiTest.UT01_Post_CreateUser.userLoginId;

public class UT06_Delete_DeleteUser extends GMIBankBaseUrl {

    @Test
    public void UT06_deleteUser() {

        String userLoginID=userLoginId;

        //todo: will comment
        //userLoginID="muratazak";

        //Set the url
        specWithAutherization.pathParams("first","users","second",userLoginID);

        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
        Response response = given().
                spec(specWithAutherization).
                contentType(ContentType.JSON).when().delete("/{first}/{second}");

        response.prettyPrint();

        //Do assertion
        assertThat(response.statusCode(), equalTo(SC_NO_CONTENT)); //204

    }


}
