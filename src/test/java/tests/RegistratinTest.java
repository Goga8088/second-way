package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistratinTest  {

    @BeforeAll
    static void beforeAll( ) {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;

    }


        @Test
        void successfulRegistrationTest( ) {
             String userName = "Alex";

             // открыть страницу регистрации
            open("/automation-practice-form");

            // проверка открытия
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

            // удаление футера, чтобы кнопка submit была доступнв
            executeJavaScript("$('footer').remove()");

            // заполенения имени
            $("#firstName").setValue(userName);

            // заполнение фамилии
            $("#lastName").setValue("Egorov");

            // заполнение эл почты
            $("#userEmail").setValue("egorov@test.ru");

            // выбор пола
            $("#genterWrapper").$(byText("Other")).click();

            //заполенение номера телефона
            $("#userNumber").setValue("1234567890");

            // заполенение дня рождения
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("1998");
            $(".react-datepicker__day--030:not(.react-datepicker__day--030 react-datepicker__day--outside-month)").click();

            // выбор предмета
            $("#subjectsInput").setValue("Math").pressEnter();

            // выбор хобби
            $("#hobbiesWrapper").$(byText("Sports")).click();

            // загрузка картинки
            $("#uploadPicture").uploadFromClasspath("img/1.png");
            //$("#uploadPicture").uploadFile( new File("src/test/resources/img/1.png"));

            // ввод адреса
            $("#currentAddress").setValue("Some address 1");

            // выбор страны и городе
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();

            // регистрация
            $("#submit").click();

            // проверки
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text(userName), text("Egorov"), text("egorov@test.ru"), text("1234567890"));

        }
}

