package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestStartPage {



    private final WebDriver driver;
    @FindBy(xpath = "//button[text()='Re-attempt quiz']")
    private WebElement reattemptQuit;
    @FindBy(xpath = "//input[@id='id_submitbutton']")
    private WebElement startAttempt;

    public TestStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TestStartPage clickReattemptQuiz() {
        Utils.jsClick(reattemptQuit, driver);
        return this;
    }

    public TestPage clickStartAttempt() {
        Utils.jsClick(startAttempt, driver);
        return new TestPage(driver);
    }
}
