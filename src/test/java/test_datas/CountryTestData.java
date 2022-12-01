package test_datas;

import pojos.Country;
import pojos.State;
import pojos.payloads.CountryPayload;


import java.util.ArrayList;
import java.util.List;

public class CountryTestData {
    public static CountryPayload getTestDataForCountryPayrol() {
        ArrayList<State> states=new ArrayList<>();
        states.add(new State(1,"Ontario",null));
        states.add(new State(2,"Quebec",null));
        states.add(new State(3,"British Columbia",null));

        CountryPayload country=new CountryPayload("Canada",states);
        //System.out.println("Expected Data = "+expectedData);

        return country;
    }
    public static Country getTestDataForCountryPayrol_for_put(int countryId) {
        ArrayList<State> states=new ArrayList<>();
        states.add(new State(1,"Karadeniz",null));
        states.add(new State(2,"Ege",null));
        states.add(new State(3,"Akdeniz",null));

        Country country=new Country(countryId,"Canada-Updated",states);
        //System.out.println("Expected Data = "+expectedData);

        return country;
    }

}
