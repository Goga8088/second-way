package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RegistrationWithPageObjectTests  {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
        Configuration.timeout = 50;
//        Configuration.holdBrowserOpen = true;
    }

        RegistrationPage registrationPage = new RegistrationPage();


        @Test
         void successfulRegistrationTest( ) {
            registrationPage.openPage()
                            .setFirstName("Alex")
                            .setLastName("Egorov")
                            .setEmail("egorov@test.ru")
                            .setGender("Other")
                            .setUserNumber("1234567890")
                            .setDateOfBirth("30", "July", "1998")
                            .setSubjects("Math")
                            .setHobbies("Sports")
                            .uploadPicture("img/1.png")
                            .setCurrentAddress("Some address 1")
                            .setState("NCR")
                            .setCity("Delhi")

                            .submit();

                   /*
                   .checkResult("Student Name", "Jensen Huang")
                   .checkResult("Student Email", "test@mail.com")
                   .checkResult("Gender", "Male")
                   .checkResult("Mobile", "1111111111")
                   .checkResult("Date of Birth", "30 May,1970")
                   .checkResult("Subjects", "Physics, Computer Science")
                   .checkResult("Hobbies", "Reading, Music")
                   .checkResult("Picture", "selenide-logo-big.png")
                   .checkResult("Address", "Groove street 1")
                   .checkResult("State and City", "Haryana Panipat");
                   */


            registrationPage.checkResult("Student Name", "Alex Egorov")
                            .checkResult("Student Email", "egorov@test.ru");

        }

   @Test
   void RegistrationRequiredFieldsTest(){
      registrationPage.openPage()
              .setFirstName("Ada")
              .setLastName("Lovelace")
              .setGender("Female")
              .setUserNumber("7999999999")
              .submit()
              .checkResult("Student Name", "Ada Lovelace")
              .checkResult("Gender", "Female")
              .checkResult("Mobile", "7999999999");
   }

  /* @Test
   void emptyRegistrationFormTest(){
      registrationPage.openPage()
              .submit()
              .checkValidation();
   }

   */
}


