package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectTests extends TestBase  {


        RegistrationPage registrationPage = new RegistrationPage();


        @Test
         void successfulRegistrationTest( ) {
            registrationPage.openPage()
                            .setFirstName("Alex")
                            .setLastName("Egorov")
                            .setEmail("egorov@test.ru")
                            .setGender("Other")
                            .setUserNumber("1234567890")
                            .setDateOfBirth("30", "July", "1998");




            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1998");
            $(".react-datepicker__day--030:not(.react-datepicker__day--030 react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("img/1.png");
            $("#currentAddress").setValue("Some address 1");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();


            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Alex"), text("Egorov"), text("egorov@test.ru"), text("1234567890"));

            registrationPage.checkResult("Student Name", "Alex Egorov")
                            .checkResult("Student Email", "egorov@test.ru");

        }
}

