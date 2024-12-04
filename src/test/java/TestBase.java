import com.codeborne.selenide.Configuration;
import config.WebConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup() {

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.browserVersion = config.browserVersion();

        if (System.getProperty("env", "local").equals("remote")) {
                Configuration.remote = config.remoteUrl();
        }
        else {
            Configuration.remote = null; }

        Configuration.baseUrl = config.baseUrl();
        Configuration.pageLoadStrategy = "eager";
        RestAssured.baseURI = config.baseUrl();

    }
}
