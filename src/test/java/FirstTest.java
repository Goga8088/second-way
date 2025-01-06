import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    int result;

    @BeforeEach
    void beforeEach( ) {
        System.out.println("####  beforeEach" );
        result = getResult();
    }

    @Test
    void firstTest() {
        System.out.println("####  firstTest" );
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }


    @Test
    void secondTest() {
        int result = getResult();
        System.out.println("####  secondTest" );
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        int result = getResult();
        System.out.println("####  third Test" );
        Assertions.assertTrue(result > 2);
    }
}
