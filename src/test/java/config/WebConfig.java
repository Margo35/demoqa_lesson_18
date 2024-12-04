package config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${env}.properties")
public interface WebConfig extends Config {

    @DefaultValue("https://demoqa.com")
    String baseUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1280x1024")
    String browserSize();

    @DefaultValue("124.0")
    String browserVersion();

    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}
