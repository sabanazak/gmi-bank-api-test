package tests.TpAccountRegistrations;


import base_urls.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Account;
import pojos.payloads.AccountPayload;
import test_datas.AccountTestData;


import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class AR01_Post_CreateAccount extends GMIBankBaseUrl {
/*

    Given
        https://www.gmibank.com/api/tp-account-registrations
    And
        {
            "ssn": "111-22-333",
            "firstName": "Saban",
            "lastName": "AZAK",
            "address": "Bilmem nire",
            "mobilePhoneNumber": "226-222-3344",
            "userId": 135531,
            "userName": "azaksaban",
            "email": "azak@saban.com",
        }
    When
        User sends Post request
    Then
        Status code must be 201
    And
        Response body is like
                {
                    "id": 164140,
                    "ssn": "111-22-333",
                    "firstName": "Saban",
                    "lastName": "AZAK",
                    "address": "Bilmem nire",
                    "mobilePhoneNumber": "226-222-3344",
                    "userId": 135531,
                    "userName": "azaksaban",
                    "email": "azak@saban.com",
                    "createDate": null
                }
 */
    static int ACCOUNT_ID;
    static String ACCOUNT_SSN;
    @Test
    public void AR01_createTPAccountRegistration() {

        specWithAutherization.pathParam("first","tp-account-registrations");

        //payload : expectedData
        AccountPayload expectedData = AccountTestData.getTestDataForAccountPayload();
        System.out.println("Expected Data = "+expectedData);

        //Request - Response
        Response response=given().
                                spec(specWithAutherization).
                                contentType(ContentType.JSON).
                                body(expectedData).
                            when().
                                post("/{first}");
        response.prettyPrint();

        Account actualData= response.as(Account.class);
        System.out.println("Actual Data = "+actualData);

        assertThat(response.statusCode(), equalTo(SC_CREATED));  //201
        assertEquals(expectedData.getUserName(),actualData.getUserName());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
        assertEquals(expectedData.getSsn(),actualData.getSsn());
        assertEquals(expectedData.getMobilePhoneNumber(),actualData.getMobilePhoneNumber());

        ACCOUNT_ID=actualData.getId();
        ACCOUNT_SSN=actualData.getSsn();

    }

}
