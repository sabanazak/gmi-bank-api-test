package pojos;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User_Response {
    private int id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated;
    private String langKey;
    private String imageUrl;
    private String resetDate;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;
    private ArrayList<String> authorities;

}
