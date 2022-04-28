package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestEndPage {

    private final WebDriver driver;
    @FindBy(xpath = "//button[text()='Submit all and finish']")
    private WebElement finishAttempt;
    @FindBy(xpath = "//div[@class='submitbtns']//a[text()='Finish review']")
    private WebElement finishReview;
    @FindBy(xpath = "//span[@id='actionmenuaction-6']")
    private WebElement logoutButton;




    public TestEndPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TestEndPage submitAndFinish() {
        Utils.jsClick(finishAttempt, driver);
        return this;
    }

    public TestEndPage finishReview() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.jsClick(finishReview, driver);
        return this;
    }

    public LogOutPage clickLogOut() {
        Utils.jsClick(logoutButton, driver);
        return new LogOutPage(driver);
    }
}
