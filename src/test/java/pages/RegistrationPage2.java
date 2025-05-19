package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CalendarComponent2;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage2 {

    ///// SelenideElements
    CalendarComponent2 calendar = new CalendarComponent2();
    SelenideElement titleLabel = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber");


    ///// Actions
    public RegistrationPage2 openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage2 setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

//    public void clickFirstName() { // not used
//        firstNameInput.click();
//    }

    public RegistrationPage2 setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage2 setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage2 setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage2 setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage2 setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate("30", "July", "2008");

        return this;
    }


    public RegistrationPage2 checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

}
