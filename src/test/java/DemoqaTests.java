import api.AuthorizationApi;
import api.BooksApi;
import data.AuthData;
import models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;

public class DemoqaTests extends TestBase {

    @Test
    void deleteBookTest() {

        CredentialsModel credentials = new CredentialsModel();
        AuthData authData = new AuthData();
        BookCollectionRequestModel bookCollection = new BookCollectionRequestModel();
        BookRequestModel book = new BookRequestModel();
        List<IsbnModel> isbnList = new ArrayList<>();
        IsbnModel isbn = new IsbnModel();
        isbn.setIsbn("9781449365035");
        isbnList.add(isbn);

        LoginResponseModel loginResponse = step("Отправляем POST запрос на логин", () ->
                AuthorizationApi.login(credentials, authData));

        step("Отправляем POST запрос на добавление книги в корзину", () ->
                BooksApi.addBook(loginResponse, bookCollection, isbnList));

        step("Отправляем DELETE запрос на удаление книги из корзины", () ->
                BooksApi.deleteBook(loginResponse, book, isbn));

    }
}
