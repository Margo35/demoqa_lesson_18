package api;

import helpers.NumberIsbn;
import io.qameta.allure.Step;
import io.restassured.specification.ResponseSpecification;
import models.BookCollectionRequestModel;
import models.BookRequestModel;
import models.IsbnModel;
import models.LoginResponseModel;
import org.openqa.selenium.Cookie;
import specs.Spec;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.String.format;
import static specs.Spec.requestSpec;

public class BooksApi {

    @Step("Отправляем POST запрос на добавление книги в корзину")
    public void addBook(LoginResponseModel loginResponse, BookCollectionRequestModel bookCollection,
                               List<IsbnModel> isbnList) {

        bookCollection.setUserId(loginResponse.getUserId());
        bookCollection.setCollectionOfIsbns(isbnList);

        given(requestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(bookCollection)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(Spec.createResponseSpec(201));

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));


    }

    @Step("Очищаем корзину")
    public void deleteAllBooks(LoginResponseModel loginResponse) {
        given(requestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParams("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(Spec.createResponseSpec(204));
    }


}
