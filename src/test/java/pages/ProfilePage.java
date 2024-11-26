package pages;

import helpers.NumberIsbn;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

public static void openProfile () {
    open("/profile");
}

public static void deleteBook (){
        $("#delete-record-undefined").scrollTo().click();
        $("#closeSmallModal-ok").scrollTo().click();
    }

    public static void checkDeletedBook (String isbn){
        $(".ReactTable").shouldNotHave(text(NumberIsbn.getIsbn(isbn)));
    }

}
