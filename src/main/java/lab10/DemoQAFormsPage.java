package lab10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAFormsPage {

    private final WebDriver driver;
    @FindBy(xpath = "//span[text()='Practice Form']//ancestor::li[@id='item-0']")
    private WebElement formsLi;

    public DemoQAFormsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DemoQAFormsPage clickForms() {
        Utils.jsClick(formsLi, driver);
        return this;
    }
}
