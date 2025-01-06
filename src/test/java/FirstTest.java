import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
    }
}
