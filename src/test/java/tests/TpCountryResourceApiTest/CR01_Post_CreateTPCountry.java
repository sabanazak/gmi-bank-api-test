package tests.TpCountryResourceApiTest;


import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.State;
import pojos.User_Response;
import pojos.payloads.CountryPayload;
import pojos.payloads.User_Payload;
import test_datas.CountryTestData;
import test_datas.UserTestData;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utils.AuthUtils.generateToken;

public class CR01_Post_CreateTPCountry extends GMIBankBaseUrl {
/*

    Given
        https://www.gmibank.com/api/tp-countries
    And
            {
                "name": "Canada",
                "states": [
                    {
                        "id": 1,
                        "name": "Ontario",
                        "tpcountry": null
                    }
                ]
            }
    When
        User sends Post request
    Then
        Status code must be 201
    And
        Response body is like
            {
                "id": 172470,
                "name": "Canada",
                "states": [
                    {
                        "id": 1,
                        "name": "Ontario",
                        "tpcountry": null
                    }
                ]
            }
 */

    static int countryId;
    @Test
    public void CR01_creteCountry() {

        specWithAutherization.pathParam("first","tp-countries");

        //payload : expectedData
        CountryPayload expectedData= CountryTestData.getTestDataForCountryPayrol();
        System.out.println("Expected Data = "+expectedData);

        //Request - Response
        Response response=given().
                                baseUri("https://www.gmibank.com/api/").
                                basePath("tp-countries").
                                headers("Authorization","Bearer "+generateToken()).
                                contentType(ContentType.JSON).
                                body(expectedData).
                            when().
                                post();
        response.prettyPrint();

        Country actualData= response.as(Country.class);
        System.out.println("Actual Data = "+actualData);

        assertThat(response.statusCode(), equalTo(SC_CREATED));  //201
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getStates().size(),actualData.getStates().size());

        countryId=actualData.getId();

    }

}
