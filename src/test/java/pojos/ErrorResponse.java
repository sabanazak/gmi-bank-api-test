package pojos;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    private String entityName;
    private String errorKey;
    private String type;
    private String title;
    private Integer status;
    private String message;
    private String params;

}
