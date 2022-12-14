package tests.TpCountryResourceApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static tests.TpCountryResourceApiTest.CR01_Post_CreateTPCountry.COUNTRY_ID;

public class CR06_Delete_DeleteCountry extends GMIBankBaseUrl {

    @Test
    public void CR06_deleteCountry() {

        //Set uri
        specWithAutherization.pathParams("first","tp-countries","second",COUNTRY_ID);

        //Set Expected data

        //Send the request
        Response response = given().
                                spec(specWithAutherization).
                                contentType(ContentType.JSON).
                            when().
                                delete("/{first}/{second}");

        response.prettyPrint();
        assertEquals(204,response.statusCode());

    }


}
