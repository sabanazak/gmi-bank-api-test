package pojos.payloads;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountPayload {
    //private  int id;
    private  int userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String ssn;
    private String mobilePhoneNumber;
    private String address;
    //private String createDate;
}
