package tests.TpAccountRegistrations;

import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import test_datas.AccountTestData;

import static io.restassured.RestAssured.given;
import static tests.TpAccountRegistrations.AR01_Post_CreateAccount.*;


public class AR04_Put_UpdateAccount extends GMIBankBaseUrl {

    @Test
    public void AR04_updateTPAccountRegistration() {
        //accountId=164141;
        //accountSSN="111-22-333";
        //Set the url
        specWithAutherization.pathParams("first","tp-account-registrations");

        Account expectedData= AccountTestData.getTestDataForAccount(ACCOUNT_ID,ACCOUNT_SSN);
        expectedData.setFirstName("Saban-Updated");
        expectedData.setLastName("Azak-updated");
        System.out.println(expectedData);

        //Request - Response
        Response response=given().
                spec(specWithAutherization).
                contentType(ContentType.JSON).
                body(expectedData).
                when().
                put("/{first}");
        response.prettyPrint();

        Account actualData= response.as(Account.class);
        System.out.println("Actual Data = "+actualData);


    }



}
