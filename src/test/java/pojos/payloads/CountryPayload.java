package pojos.payloads;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import pojos.State;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryPayload {

    private String name;
    private ArrayList<State> states;

    public CountryPayload(String name, ArrayList<State> states) {
        this.name = name;
        this.states = states;
    }

    public CountryPayload() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CountryPost{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}