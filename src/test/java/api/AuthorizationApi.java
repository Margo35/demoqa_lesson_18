package api;

import config.AuthConfig;
import data.AuthData;
import io.restassured.http.ContentType;
import models.CredentialsModel;
import models.LoginResponseModel;
import specs.Spec;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.http.ContentType.JSON;
import static specs.Spec.requestSpec;

public class AuthorizationApi {

    public static LoginResponseModel login(CredentialsModel credentials, AuthConfig authConfig) {
        credentials.setUserName(authConfig.userName());
        credentials.setPassword(authConfig.password());
        return given(requestSpec)
                .body(credentials)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(Spec.createResponseSpec(200))
                .extract().as(LoginResponseModel.class);
    }

}
