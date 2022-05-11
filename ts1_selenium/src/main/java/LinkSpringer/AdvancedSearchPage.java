package LinkSpringer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {

    private final WebDriver driver;
    @FindBy(xpath = "//input[@id='all-words']")
    private WebElement allWordsInput;
    @FindBy(xpath = "//input[@id='least-words']")
    private WebElement leastWordsInput;
    @FindBy(xpath = "//input[@id='facet-start-year']")
    private WebElement startYearInput;
    @FindBy(xpath = "//input[@id='facet-end-year']")
    private WebElement endYearInput;
    @FindBy(xpath = "//button[@id='submit-advanced-search']")
    private WebElement searchButton;

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdvancedSearchPage searchFillAllWords(String query) {
        allWordsInput.sendKeys(query);
        return this;
    }

    public AdvancedSearchPage searchFillLeastWords(String query) {
        leastWordsInput.sendKeys(query);
        return this;
    }

    public AdvancedSearchPage fillStartYear(String query) {
        startYearInput.sendKeys(query);
        return this;
    }

    public AdvancedSearchPage fillEndYear(String query) {
        endYearInput.sendKeys(query);
        return this;
    }

    public SearchPage clickSearch() {
        MyUtils.jsClick(searchButton, driver);
        return new SearchPage(driver);
    }
}

