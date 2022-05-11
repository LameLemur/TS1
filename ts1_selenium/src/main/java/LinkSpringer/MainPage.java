package LinkSpringer;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;
    @FindBy(xpath = "//a[@id='advanced-search-link']")
    private WebElement advancedSearchButton;
    @FindBy(xpath = "//div[@id='header']//div[@class='cross-nav cross-nav--wide']//a[@class='register-link flyout-caption']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='query']")
    private WebElement searchBox;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://link.springer.com");
    }

    public MainPage(WebDriver driver, boolean openNew) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpLoginPage clickLogin() {
        MyUtils.jsClick(loginButton, driver);
        return new SignUpLoginPage(driver);
    }

    public AdvancedSearchPage clickAdvancedSearch() {
        MyUtils.jsClick(advancedSearchButton, driver);
        return new AdvancedSearchPage(driver);
    }

    public SearchPage searchString(String toBeSearched) {

        searchBox.sendKeys(toBeSearched);
        MyUtils.jsClick(searchButton, driver);
        return new SearchPage(driver);
    }
}
