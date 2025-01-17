package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamplese {

    void cssXpath() {
        // <input type="email" class="inputtext login_form_input_box" name="email"  data-testid="email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid",  "email]")).setValue("1");
        $x("//*[@data-testid=' email']").setValue("1");


        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1");
        $(by("id",  "email]")).setValue("1");
        $(byId("email]")).setValue("1");
        $("#email").setValue("1");
        $x("//*[@id=' email']").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1");
        $(by("name",  "email]")).setValue("1");
        $(byName("email]")).setValue("1");
        $("#email").setValue("1");
        $x("//*[@name=' email']").setValue("1");


        // <input type="email" class="inputtext login_form_input_box">
        $("[class=inputext][calss=login_form_input_box ]").setValue("1");
        $(".inputext.login_form_input_box").setValue("1");

    }


}
