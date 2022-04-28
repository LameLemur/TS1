package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

    private final WebDriver driver;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;


    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogOutPage clickContinue() {
        Utils.jsClick(continueButton, driver);
        return this;
    }
}
