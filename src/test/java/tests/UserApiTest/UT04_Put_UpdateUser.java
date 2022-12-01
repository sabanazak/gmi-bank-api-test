package tests.UserApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.junit.Test;
import pojos.ErrorResponse;
import pojos.User_Response;
import pojos.payloads.User_Payload;
import test_datas.UserTestData;
import utils.JSONUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UT04_Put_UpdateUser extends GMIBankBaseUrl {
    /*

     */

    @Test
    public void UT04_updateUser() {
        specWithAutherization.pathParam("first","users");

        //payload : expectedData
        User_Payload expectedData= UserTestData.getTestDataForUserPayrol();
        expectedData.setFirstName("Muratovski");
        expectedData.setResetDate("2022-11-30T19:45:34.762694Z");

        //Request - Response
        // FAILED.::::: COULD NOT FIND HOW TO UPDATE

        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                body(expectedData).
                when().put("/{first}");
        response.prettyPrint();

        if(response.statusCode()!=200){
            ErrorResponse error= JSONUtils.convertJsonToJavaObject(response.asString(), ErrorResponse.class);
            System.out.println("------- HATA : İşme Başarısız -------");
            System.out.println(error);
            return;
        }
        User_Response actualData= response.as(User_Response.class);
        System.out.println("Actual Data = "+actualData);


    }
}
