package tests.TpAccountRegistrations;

import base_urls.GMIBankBaseUrl;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import pojos.Account;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AR05_Get_GetAllAccounts extends GMIBankBaseUrl {
    @Test
    public void AR02_getAllTPAccounts() {

        specWithAutherization.pathParams("first","tp-account-registrations");

        //Request - Response
        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}");
        response.prettyPrint();

        ArrayList<Account> aList1=response.path("");
        System.out.println(aList1.size());

        ArrayList<Account> aList2=response.body().as(new TypeRef<ArrayList<Account>>(){});
        System.out.println(aList2.size());

        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("azaksaban"));

        response.then().
                assertThat().
                contentType(ContentType.JSON).
                body("userName", Matchers.hasItem("azaksaban"));




    }
}
