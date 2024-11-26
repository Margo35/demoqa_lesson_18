import api.AuthorizationApi;
import api.BooksApi;
import config.AuthConfig;
import data.AuthData;
import models.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;
import specs.Spec;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static specs.Spec.requestSpec;

public class DemoqaTests extends TestBase {

    @Test
    void deleteBookTest() {

        CredentialsModel credentials = new CredentialsModel();
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
        //AuthData authData = new AuthData();
        BookCollectionRequestModel bookCollection = new BookCollectionRequestModel();
        BookRequestModel book = new BookRequestModel();
        List<IsbnModel> isbnList = new ArrayList<>();
        IsbnModel isbn = new IsbnModel();
        isbn.setIsbn("9781449365035");
        isbnList.add(isbn);

        LoginResponseModel loginResponse = step("Отправляем POST запрос на логин", () ->
                AuthorizationApi.login(credentials, authConfig));

        step("Очищаем корзину", () ->
                BooksApi.deleteAllBooks(loginResponse));

        step("Отправляем POST запрос на добавление книги в корзину", () ->
                BooksApi.addBook(loginResponse, bookCollection, isbnList));

        step("Отправляем DELETE запрос на удаление книги из корзины",
                ProfilePage::deleteBook);

        step("Проверяем, что книга удалена", () -> {
                    ProfilePage.openProfile();
                    ProfilePage.checkDeletedBook(isbn.getIsbn());
                }
        );

    }
}
