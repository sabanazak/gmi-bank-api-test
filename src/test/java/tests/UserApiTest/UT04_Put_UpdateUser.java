package tests.UserApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.User_Response;
import pojos.payloads.User_Payload;
import test_datas.UserTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UT04_Put_UpdateUser extends GMIBankBaseUrl {
    /*

     */

    @Test
    public void UT04_updateUser() {
        specWithAutherization.pathParam("first","users");

        //payload : expectedData
        Map<String,Object> expectedData= UserTestData.getTestDataForUserUpdate();
        System.out.println("Expected Data = "+expectedData);

        //Request - Response
        /* FAILED.::::: COULD NOT FIND HOW TO UPDATE
        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                body(expectedData).
                when().put("/{first}");
        response.prettyPrint();
         */
        //User_Response actualData= response.as(User_Response.class);
        //System.out.println("Actual Data = "+actualData);


    }
}
