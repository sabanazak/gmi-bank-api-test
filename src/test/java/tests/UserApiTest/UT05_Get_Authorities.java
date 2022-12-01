package tests.UserApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.User_Response;
import pojos.payloads.User_Payload;
import test_datas.UserTestData;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static tests.UserApiTest.UT01_Post_CreateUser.USER_LOGIN_ID;


public class UT05_Get_Authorities extends GMIBankBaseUrl {
/*
    Given
        https://www.gmibank.com/api/users/authorities
    When
        User sends Get request
    Then
        Status code must be 200
    And
        Response body is like
            [
                "ROLE_ADMIN",
                "ROLE_USER",
                "ROLE_EMPLOYEE",
                "ROLE_MANAGER",
                "ROLE_CUSTOMER"
            ]
 */
    @Test
    public void UT05_getAuthorities() {

        //Set the url
        specWithAutherization.pathParams("first","users","second","authorities");

        //Set Expected Data
        String expectedData= USER_LOGIN_ID;

        //Request - Response
        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertions
        List<String> roles=response.body().as(new TypeRef<List<String>>(){});
        System.out.println(roles);

        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("ROLE_ADMIN"));



    }



}
