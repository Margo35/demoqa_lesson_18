import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.browser = System.getProperty("browser");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.remote = System.getProperty("wdHOST");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        RestAssured.baseURI = "https://demoqa.com";

    }
}
