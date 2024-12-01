import api.AuthorizationApi;
import api.BooksApi;
import config.AuthConfig;
import models.BookCollectionRequestModel;
import models.CredentialsModel;
import models.IsbnModel;
import models.LoginResponseModel;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

import java.util.ArrayList;
import java.util.List;

public class DemoqaTests extends TestBase {

    @Test
    void deleteBookTest() {

        CredentialsModel credentials = new CredentialsModel();
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);
        ProfilePage profilePage = new ProfilePage();
        AuthorizationApi authorizationApi = new AuthorizationApi();
        BooksApi booksApi = new BooksApi();
        BookCollectionRequestModel bookCollection = new BookCollectionRequestModel();
        List<IsbnModel> isbnList = new ArrayList<>();
        IsbnModel isbn = new IsbnModel();
        isbn.setIsbn("9781449365035");
        isbnList.add(isbn);

        LoginResponseModel loginResponse = authorizationApi.login(credentials, authConfig);
        booksApi.deleteAllBooks(loginResponse);
        booksApi.addBook(loginResponse, bookCollection, isbnList);
        ProfilePage.openProfile(isbn.getIsbn());
        profilePage.checkAddBook(isbn.getIsbn());
        profilePage.deleteBook();
        profilePage.checkDeletedBook(isbn.getIsbn());


    }
}
