package tests.TpAccountRegistrations;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import test_datas.AccountTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static tests.TpAccountRegistrations.AR01_Post_CreateAccount.*;

public class AR06_Delete_DeleteAccount extends GMIBankBaseUrl {

    @Test
    public void AR06_deleteAccountById() {

        //Set the url
        specWithAutherization.pathParams("first","tp-account-registrations","second",ACCOUNT_ID);

        //Set Expected Data

        //Request - Response
        Response response=given().spec(specWithAutherization).
                                contentType(ContentType.JSON).
                            when().
                                delete("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(204,response.statusCode());

    }
}
