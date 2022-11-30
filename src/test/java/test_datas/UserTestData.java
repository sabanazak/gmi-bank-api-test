package test_datas;

import net.datafaker.Faker;
import pojos.User_Response;
import pojos.payloads.User_Payload;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTestData {
    protected static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    protected static Faker faker = new Faker();

    public static User_Payload getTestDataForUserPayrolByFaker() {
        User_Payload user=new User_Payload();
        user.setLogin(faker.name().username());
        user.setFirstName("Saban");
        user.setLastName("AZAK");
        user.setEmail(faker.internet().emailAddress());
        user.setActivated(true);
        user.setLangKey("EN");
        user.setImageUrl(null);
        //user.setResetDate(sdfDate.format(new Date()));

        List<String> authorities=new ArrayList<>();
        authorities.add("ADMIN");
        user.setAuthorities(authorities);
        return user;
    }

    public static User_Payload getTestDataForUserPayrol() {
        User_Payload user=new User_Payload();
        user.setLogin("muratazak");
        user.setFirstName("Murat");
        user.setLastName("AZAK");
        user.setEmail("murat@azak.com");
        user.setActivated(true);
        user.setLangKey("EN");
        user.setImageUrl(null);
        //user.setResetDate(sdfDate.format(new Date()));

        List<String> authorities=new ArrayList<>();
        authorities.add("ADMIN");
        user.setAuthorities(authorities);
        return user;
    }

    public static Map<String,Object> getTestDataForUserUpdate() {
        Map<String,Object> user=new HashMap<>();

        //user.put("id",164288);
        user.put("login","muratazak");
        user.put("firstnale","Murat-Updated");
        user.put("lastname","AZAK");
        //user.put("email","murat.update@azak.com");
        return user;
    }

}
