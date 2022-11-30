package pojos.payloads;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthRequestPayload {

  private String password;
  private Boolean rememberme;
  private String username;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getRememberme() {
    return rememberme;
  }

  public void setRememberme(Boolean rememberme) {
    this.rememberme = rememberme;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AuthRequestPayload(String password, Boolean rememberme, String username) {
    this.password = password;
    this.rememberme = rememberme;
    this.username = username;
  }

  public AuthRequestPayload() {
  }

  @Override
  public String toString() {
    return "AuthRequestPayload{" +
            "password='" + password + '\'' +
            ", rememberme='" + rememberme + '\'' +
            ", username='" + username + '\'' +
            '}';
  }
}
