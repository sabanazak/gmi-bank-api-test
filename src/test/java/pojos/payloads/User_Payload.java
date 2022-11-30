package pojos.payloads;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User_Payload {
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated;
    private String langKey;
    private String imageUrl;

    //Below is not needed
    private String resetDate;
    private List<String> authorities;
    private String createdBy;
    private String createdDate;
    private String lastModifiedBy;
    private String lastModifiedDate;

}

/*
{

  "authorities": [
    "OTORITE"
  ],
  "createdBy": "cbSaban",
  "createdDate": "2022-11-29T20:08:23.499Z",



  "lastModifiedBy": "string",
  "lastModifiedDate": "2022-11-29T20:08:23.499Z",

}

{
    "id": 164280,
    "login": "sazak",
    "firstName": "Saban",
    "lastName": "Azak",
    "email": "saban1@azak.com",
    "activated": true,
    "langKey": "string",
    "imageUrl": "string",
    "resetDate": "2022-11-29T20:18:36.987173Z"
}
 */
