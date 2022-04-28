package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoodleLoginPage {

    private final WebDriver driver;
    @FindBy(xpath = "//a//i[@class='fa fa-sign-in']")
    private WebElement loginButton;

    public MoodleLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://moodle.fel.cvut.cz/login/index.php");
    }

    public SSOLoginPage clickLogin() {
        Utils.jsClick(loginButton, driver);
        return new SSOLoginPage(driver);
    }
}
