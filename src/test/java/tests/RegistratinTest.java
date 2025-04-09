package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistratinTest {


    @BeforeAll
    static void beforeAll( ) {
       Configuration.browserSize = "1920x1080";
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.pageLoadStrategy = "eager";
       Configuration.holdBrowserOpen = true;
       Configuration.timeout = 5000;

    }


        @Test
        void successfulRegistrationTest( ) {
             String userName = "Alex";

            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

            $("#firstName").setValue(userName);
            $("#lastName").setValue("Egorov");
            $("#userEmail").setValue("egorov@test.ru");
            $("#userNumber").setValue("1234567890");
            $("#currentAddress").setValue("Some address 1");





            //$("#output #name").shouldHave(text("Alex")).pressEnter();
           // $("#output #email").shouldHave(text("alex@alex.fgf")).pressEnter();
           // $("#output #currentAddress").shouldHave(text("Some street 1")).pressEnter();
           // $("#output #permanentAddress").shouldHave(text("Another street 2")).pressEnter();
        }
}

