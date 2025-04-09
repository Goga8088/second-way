package Examplse;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
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
        $(" .login_form_input_box").setValue("1");
        $(".inputext.login_form_input_box").setValue("1");
        $("input.inputext.login_form_input_box").setValue("1");
        $x("//input[@class=inputext][@calss=login_form_input_box ]").setValue("1");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputext. login_form_input_box").setValue("1");

        // <div> Hello, qa.quru!</div> (Поиск по тексту, пример)
        $(byText("Hello, qa.quru!"));
        $(withText("llo, qa.quru"));
        $x("//*[contains(text(), 'Hello, qa.quru!') )]");



    }


}
