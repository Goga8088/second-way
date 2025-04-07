package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.text;

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

            executeJavaScript("$('footer').remove()");

            $("#firstName").setValue(userName);
            $("#lastName").setValue("Egorov");
            $("#userEmail").setValue("egorov@test.ru");
            $("#genterWrapper").$(byText("Other")).click();
            $("#userNumber").setValue("1234567890");


            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1998");
            $(".react-datepicker__day--030:not(.react-datepicker__day--030 react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("img/1.png");
            //$("#uploadPicture").uploadFile( new File("src/test/resources/img/1.png"));
            $("#currentAddress").setValue("Some address 1");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();

            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text(userName), text("Egorov"), text("egorov@test.ru"), text("1234567890"));

}

