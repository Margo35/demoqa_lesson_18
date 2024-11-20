package models;

import lombok.Data;

@Data
public class LoginResponseModel {

    String userId, expires, token, username, password, created_date;
    Boolean isActive;


}
