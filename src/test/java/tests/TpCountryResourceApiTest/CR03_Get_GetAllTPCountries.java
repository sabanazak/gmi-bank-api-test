package tests.TpCountryResourceApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static tests.TpCountryResourceApiTest.CR01_Post_CreateTPCountry.countryId;

public class CR03_Get_GetAllTPCountries extends GMIBankBaseUrl {

    @Test
    public void CR02_getAllTPCountries() {
        //Set uri
        specWithAutherization.pathParams("first","tp-countries");

        //Set Expected data

        //Send the request
        Response response = given().
                spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}");

        response.prettyPrint();

        assertEquals(200,response.statusCode());
    }
}
