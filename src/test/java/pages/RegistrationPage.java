package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CityComponent;
import pages.components.StateComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {

    public SelenideElement firstNameInput = $("#firstName"),

    lastNameInput = $("#lastName"),
    useEmailInput = $("#userEmail"),
    genterWrapper = $("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectsInput = $("#subjectsInput"),
    hobbiesWrapperInput = $("#hobbiesWrapper"),
    uploadPicture = $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    submitClick = $("#submit"),
    outputTable= $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();




    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }


    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        useEmailInput.setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;

    }


    public RegistrationPage setDateOfBirth(String day, String month, String year) {
         calendarInput.click();
         calendarComponent.setDate("#dateOfBirthInput", day, month, year);

        return this;

    }


    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateComponent.setState(value);
        return this;
    }

    public RegistrationPage setCity(String value){
        cityComponent.setCity(value);
        return this;
    }

    public RegistrationPage submit(){
        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;
    }


    public RegistrationPage checkFormControl(){
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }



    public RegistrationPage checkResult(String key, String value) {
    $(".table-responsive").$(byText(key)).parent()
            .shouldHave(text(value));

        return this;

    }


}