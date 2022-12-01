package tests.UserApiTest;


import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.User_Response;
import pojos.payloads.User_Payload;
import test_datas.UserTestData;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class UT01_Post_CreateUser extends GMIBankBaseUrl {
/*

    Given
        https://www.gmibank.com/api/users
    And
        {
            "login": "muratazak",
            "firstName": "Murat",
            "lastName": "AZAK",
            "email": "murat@azak.com",
            "activated": true,
            "langKey": "EN",
            "imageUrl": null
        }
    When
        User sends Post request
    Then
        Status code must be 201
    And
        Response body is like
            {
                "id": 164288,
                "login": "muratazak",
                "firstName": "Murat",
                "lastName": "AZAK",
                "email": "murat@azak.com",
                "activated": true,
                "langKey": "EN",
                "imageUrl": null,
                "resetDate": "2022-11-29T22:08:14.518666Z"
            }
 */
    static String USER_LOGIN_ID;
    @Test
    public void UT01_creteUser() {

        specWithAutherization.pathParam("first","users");

        //payload : expectedData
        User_Payload user= UserTestData.getTestDataForUserPayrol();
        System.out.println("Expected Data = "+user);

        //Request - Response
        Response response=given().
                                spec(specWithAutherization).
                                contentType(ContentType.JSON).
                                body(user).
                            when().
                                post("/{first}");
        response.prettyPrint();

        //Or
        /*
        Response response1=given().contentType(ContentType.JSON).
                                    baseUri("https://www.gmibank.com/api/").
                                    basePath("users").
                                    headers("Authorization","Bearer "+generateToken()).
                                    body(user).
                            when().
                                    post();
        response1.prettyPrint();
        */
        User_Response actualData= response.as(User_Response.class);
        System.out.println("Actual Data = "+actualData);

        assertThat(response.statusCode(), equalTo(SC_CREATED));  //201
        assertEquals(user.getLogin(),actualData.getLogin());
        assertEquals(user.getFirstName(),actualData.getFirstName());
        assertEquals(user.getLastName(),actualData.getLastName());
        assertEquals(user.getLogin(),actualData.getLogin());
        assertEquals(user.getEmail(),actualData.getEmail());
        assertEquals(user.getLangKey(),actualData.getLangKey());

        USER_LOGIN_ID=actualData.getLogin();


    }

}
