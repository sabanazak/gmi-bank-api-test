package tests.UserApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.User_Response;
import pojos.payloads.User_Payload;
import test_datas.UserTestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tests.UserApiTest.UT01_Post_CreateUser.userLoginId;

public class UT02_Get_GetUserByLoginId extends GMIBankBaseUrl {
/*
    Given
        https://www.gmibank.com/api/users
    When
        User sends Get request
    Then
        Status code must be 200
    And
        Response body is like

            {
                "id": 164288,
                "login": "muratazak",
                "firstName": "Murat",
                "lastName": "AZAK",
                "email": "murat@azak.com",
                "imageUrl": null,
                "activated": true,
                "langKey": "EN",
                "createdBy": "john_doe",
                "createdDate": "2022-11-29T22:12:56.705010Z",
                "lastModifiedBy": "john_doe",
                "lastModifiedDate": "2022-11-29T22:12:56.705010Z",
                "authorities": [

                ]
            }
 */
    @Test
    public void UT02_getUser() {
        String userLoginID=userLoginId;

        //todo: will comment
        //userLoginID="muratazak";


        //Set the url
        specWithAutherization.pathParams("first","users","second",userLoginID);

        //Set Expected Data
        User_Payload expectedData= UserTestData.getTestDataForUserPayrol();

        //Request - Response
        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}/{second}");
        response.prettyPrint();

        User_Response actualData= response.as(User_Response.class);
        System.out.println("Actual Data = "+actualData);

        //Do assertion
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getLogin(),actualData.getLogin());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getLogin(),actualData.getLogin());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getLangKey(),actualData.getLangKey());

        assertTrue(response.asString().contains("createdBy"));
        assertTrue(response.asString().contains("createdDate"));
        assertTrue(response.asString().contains("lastModifiedBy"));
        assertTrue(response.asString().contains("lastModifiedDate"));
        assertTrue(response.asString().contains("authorities"));



    }



}
