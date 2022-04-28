package lab10;

import lab09.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQAMainPageTest extends TestCase {

    @Test
    public void formsTest() {
        new DemoQAMainPage(getDriver()).clickForms().clickForms();
    }
}
