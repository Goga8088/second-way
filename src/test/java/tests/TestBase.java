package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {


   // @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
//        Configuration.holdBrowserOpen = true;

    }


}
