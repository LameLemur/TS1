package lab11;

import lab10.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestPage {

    private final WebDriver driver;
    @FindBy(xpath = "//textarea//ancestor::div[@class='answer']//textarea")
    private WebElement firstAnswer;
    @FindBy(xpath = "//input//ancestor::div[@class='ablock form-inline']//input")
    private WebElement secondAnswer;
    @FindBy(xpath = "//select//ancestor::p[text()='Planetou sluneční soustavy není ']//select")
    private WebElement thirdAnswer;
    @FindBy(xpath = "//select//ancestor::p[text()='Mezi státy evropské unie patří ']//select")
    private WebElement fourthAnswer;
    @FindBy(xpath = "//input[@id='mod_quiz-next-nav']")
    private WebElement finishAttempt;


    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TestPage fillFirstAnswer(String answer) {
        firstAnswer.sendKeys(answer);
        return this;
    }

    public TestPage fillSecondAnswer(String answer) {
        secondAnswer.sendKeys(answer);
        return this;
    }

    public TestPage selectThirdAnswer(String answer) {
        Select select = new Select(thirdAnswer);
        select.selectByVisibleText(answer);
        return this;
    }

    public TestPage selectFourthAnswer(String answer) {
        Select select = new Select(fourthAnswer);
        select.selectByVisibleText(answer);
        return this;
    }

    public TestEndPage clickFinish() {
        Utils.jsClick(finishAttempt, driver);
        return new TestEndPage(driver);
    }
}
