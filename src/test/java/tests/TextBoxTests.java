package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {


    @BeforeAll
    static void beforeAll( ) {
       Configuration.browserSize = "1920x1080";
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.pageLoadStrategy = "eager";
       Configuration.holdBrowserOpen = true;
       Configuration.timeout = 5000;

    }


        @Test
        void fillFormTests( ) {
            open("/text-box");
            $("#userName").setValue("Alex");
            $("#userEmail").setValue("alex@alex.fgf");
            $("#currentAddress").setValue("Some street 1");
            $("#permanentAddress").setValue("Another street 2");
            $("#submit").click();

            $("#output #name").shouldHave(text("Alex")).pressEnter();
            $("#output #email").shouldHave(text("alex@alex.fgf")).pressEnter();
            $("#output #currentAddress").shouldHave(text("Some street 1")).pressEnter();
            $("#output #permanentAddress").shouldHave(text("Another street 2")).pressEnter();
        }
}

