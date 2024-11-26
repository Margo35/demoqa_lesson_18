package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponseModel {

    private String userId, expires, token, username, password;
    @JsonProperty("created_date")
    private String createDate;
    private Boolean isActive;


}
