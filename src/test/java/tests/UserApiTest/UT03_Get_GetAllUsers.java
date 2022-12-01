package tests.UserApiTest;

import base_urls.GMIBankBaseUrl;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.User_Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UT03_Get_GetAllUsers extends GMIBankBaseUrl {

    @Test
    public void UT03_getAllUsers() {
        //Set the url
        specWithAutherization.pathParams("first","users");

        //Set Expected Data


        //Request - Response
        Response response=given().spec(specWithAutherization).
                contentType(ContentType.JSON).
                when().
                get("/{first}");
        response.prettyPrint();

        List<User_Response> userList=response.body().as(new TypeRef<List<User_Response>>(){});
        System.out.println(userList);

        List<User_Response> userList2 = response.path("");
        System.out.println(userList2);

        System.out.println("Login Count (userList) = " + userList.size());
        List<String> logins=response.jsonPath().getList("login");
        System.out.println("Login Count = (logins) " + logins.size());

        List<User_Response> loginsWithLambda=userList.stream().filter(u->(u.getLogin().equals("muratazak"))).collect(Collectors.toList());
        System.out.println("Login (muratazak) = " + loginsWithLambda);
        //Do Assertions

        assertEquals(200,response.statusCode());


    }

}
