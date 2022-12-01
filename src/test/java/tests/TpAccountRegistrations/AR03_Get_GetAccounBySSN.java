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


public class AR03_Get_GetAccounBySSN extends GMIBankBaseUrl {
    @Test
    public void AR03_getAccountBySSN() {

        //accountId=164141;
        //accountSSN="111-22-333";
        //Set the url
        specWithAutherization.pathParams("first","tp-account-registrations/find","second",accountSSN);

        //Set Expected Data
        Account expectedData= AccountTestData.getTestDataForAccount(accountId,accountSSN);
        System.out.println(expectedData);

        //Request - Response
        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}/{second}");
        response.prettyPrint();

        Account actualData= response.as(Account.class);
        System.out.println("Actual Data = "+actualData);

        //Do assertion
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getUserName(),actualData.getUserName());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getSsn(),actualData.getSsn());
        assertEquals(expectedData.getAddress(),actualData.getAddress());

    }
}