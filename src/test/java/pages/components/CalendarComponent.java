package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;



public class CalendarComponent {

    public void setDate(String openCalendarLocator, String day, String month, String year) {
        $(openCalendarLocator).click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--030:not(.react-datepicker__day--030 react-datepicker__day--outside-month)").click();


    }

}
