package pages;

import helpers.NumberIsbn;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {

    public static void openProfile() {
        open("/profile");
    }

    @Step("Открываем страницу /profile")
    public static void openProfile(String isbn) {
        open("/profile");
    }

    @Step("Проверка отображения добавленной книги в /profile")
    public void checkAddBook(String isbn) {
        $(".ReactTable").shouldHave(text(NumberIsbn.getIsbn(isbn)));
    }


    @Step("Удаляем книгу из корзины")
    public void deleteBook() {
        $$(".rt-tr-group").first().$("#delete-record-undefined").scrollTo().click();
        $("#closeSmallModal-ok").scrollTo().click();

//        $("#delete-record-undefined").scrollTo().click(); оставила для прояснения разницы в работе
    }

    @Step("Проверяем, что книга удалена")
    public void checkDeletedBook(String isbn) {
        $(".ReactTable").shouldNotHave(text(NumberIsbn.getIsbn(isbn)));
    }

}
