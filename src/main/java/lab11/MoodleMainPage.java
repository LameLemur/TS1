package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoodleMainPage {

    private final WebDriver driver;
    @FindBy(xpath = "//a[@class='d-block h6 m-0']")
    private WebElement testButton;
    @FindBy(xpath = "//div[@class='col-12 mb-2']//a")
    private WebElement attemptQuitButton;

    public MoodleMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MoodleMainPage clickTest() {
        Utils.jsClick(testButton, driver);
        return this;
    }

public TestStartPage clickAttemptQuiz() {
        Utils.jsClick(attemptQuitButton, driver);
        return new TestStartPage(driver);
    }
}
