package LinkSpringer;

import com.sun.tools.javac.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLoginPage {

    private final WebDriver driver;
    @FindBy(xpath = "//input[@id='login-box-email']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@id='login-box-pw']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@title='Log in']")
    private WebElement loginButton;

    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpLoginPage fillUserName(String userName) {
        inputUserName.sendKeys(userName);
        return this;
    }

    public SignUpLoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage clickLogin() {
        MyUtils.jsClick(loginButton, driver);
        return new MainPage(driver,true);
    }
}
