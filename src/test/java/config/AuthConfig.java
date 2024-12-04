package config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:auth.properties")
public interface AuthConfig extends Config {
    @Key("username")
    String userName();

    String password();

}
