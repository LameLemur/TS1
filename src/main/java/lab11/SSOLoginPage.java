package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSOLoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@name='_eventId_proceed']")
    private WebElement loginButton;


    public SSOLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SSOLoginPage fillUserName(String userName) {
        inputUserName.sendKeys(userName);
        return this;
    }

    public SSOLoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MoodleMainPage clickLogin() {
        Utils.jsClick(loginButton, driver);
        return new MoodleMainPage(driver);
    }
}
