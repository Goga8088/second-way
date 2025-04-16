package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistratinTestPageObject {


    @BeforeAll
    static void beforeAll( ) {
       Configuration.browserSize = "1920x1080";
       Configuration.baseUrl = "https://demoqa.com";
       Configuration.pageLoadStrategy = "eager";
       Configuration.timeout = 5000;

    }


        @Test
        void successfulRegistrationTest( ) {


             // open("/automation-practice-form");
            // $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            // executeJavaScript("$('footer').remove()");

            registrationPage.open()
                            .setFirstName("Alex")
                            .setGender("Other")
                            .setBirthday("30", "July", "1998")
                            .checkFormAppears();


            // $(".table-responsive").shouldHave(text("Alex"), text("Egorov"), text("egorov@test.ru"), text("1234567890"));
            registrationPage.checkResult("Full Name", "Alex Egorov");

        }
}

