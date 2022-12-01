package tests.TpCountryResourceApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import test_datas.CountryTestData;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static tests.TpCountryResourceApiTest.CR01_Post_CreateTPCountry.COUNTRY_ID;
import static utils.AuthUtils.generateToken;


public class CR04_Put_CreateOrUpdateTPCountry extends GMIBankBaseUrl {
    @Test
    public void CR01_updateTPCountry() {

        //if(tpCountryId==0) tpCountryId=172470;

        specWithAutherization.pathParam("first","tp-countries");

        //payload : expectedData
        Country expectedData= CountryTestData.getTestDataForCountryPayrol_for_put(COUNTRY_ID);
        expectedData.setStates(null);
        expectedData.setName("Canada-Update");
        System.out.println("Expected Data = "+expectedData);

        //Request - Response
        Response response=given().
                baseUri("https://www.gmibank.com/api/").
                basePath("tp-countries").
                headers("Authorization","Bearer "+generateToken()).
                contentType(ContentType.JSON).
                body(expectedData).
                when().
                put();
        response.prettyPrint();

        Country actualData= response.as(Country.class);
        System.out.println("Actual Data = "+actualData);

        System.out.println(response.statusCode());
        assertThat(response.statusCode(), equalTo(SC_OK));  //20o
        assertEquals(expectedData.getName(),actualData.getName());



    }

}
