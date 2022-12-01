package tests.TpAccountRegistrations;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import test_datas.AccountTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static tests.TpAccountRegistrations.AR01_Post_CreateAccount.accountId;
import static tests.TpAccountRegistrations.AR01_Post_CreateAccount.accountSSN;

public class AR06_Delete_DeleteAccount extends GMIBankBaseUrl {

    @Test
    public void AR06_deleteAccountById() {

        //accountId=164136;

        //Set the url
        specWithAutherization.pathParams("first","tp-account-registrations","second",accountId);

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
