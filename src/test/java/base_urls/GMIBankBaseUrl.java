package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthUtils.generateToken;

public class GMIBankBaseUrl {


    protected RequestSpecification spec;
    protected RequestSpecification specWithAutherization;

    @Before
    public void setUp() {
        String API_URL="https://www.gmibank.com/api";

        specWithAutherization = new RequestSpecBuilder().
                setBaseUri(API_URL).
                addHeader("Authorization","Bearer "+generateToken()).
                build();
        spec = new RequestSpecBuilder().setBaseUri(API_URL).build();

    }
}
