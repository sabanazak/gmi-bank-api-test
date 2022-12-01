package tests.TpCountryResourceApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.payloads.CountryPayload;
import test_datas.CountryTestData;
import utils.JSONUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static tests.TpCountryResourceApiTest.CR01_Post_CreateTPCountry.countryId;

public class CR02_Get_GetTPCountry extends GMIBankBaseUrl {

    @Test
    public void CR02_getTPCountryById() {
        int tpCountryId=countryId;
        //if(tpCountryId==0) tpCountryId=172470;
        //Set uri
        specWithAutherization.pathParams("first","tp-countries","second",tpCountryId);

        //Set Expected data
        CountryPayload expectedData= CountryTestData.getTestDataForCountryPayrol();
        System.out.println("Expected Data = "+expectedData);

        //Send the request
        Response response = given().
                spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}/{second}");

        response.prettyPrint();

        Country actualData= JSONUtils.convertJsonToJavaObject(response.asString(), Country.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
    }




}
