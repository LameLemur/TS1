package LinkSpringer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private final WebDriver driver;
    @FindBy(xpath = "//span[text()='Article']//ancestor::a[@class='facet-link']")
    private WebElement articlesButton;

    @FindBy(xpath = "//ol[@id='results-list']//li[1]//a[@class='title']")
    private WebElement firstArticle;
    @FindBy(xpath = "//ol[@id='results-list']//li[2]//a[@class='title']")
    private WebElement secondArticle;
    @FindBy(xpath = "//ol[@id='results-list']//li[3]//a[@class='title']")
    private WebElement thirdArticle;
    @FindBy(xpath = "//ol[@id='results-list']//li[4]//a[@class='title']")
    private WebElement fourthArticle;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage clickArticles() {
        MyUtils.jsClick(articlesButton, driver);
        return this;
    }

    public ArticlePage clickFirstArticle() {
        MyUtils.jsClick(firstArticle, driver);
        return new ArticlePage(driver);
    }

    public ArticlePage clickSecondArticle() {
        MyUtils.jsClick(secondArticle, driver);
        return new ArticlePage(driver);
    }

    public ArticlePage clickThirdArticle() {
        MyUtils.jsClick(thirdArticle, driver);
        return new ArticlePage(driver);
    }

    public ArticlePage clickFourthArticle() {
        MyUtils.jsClick(fourthArticle, driver);
        return new ArticlePage(driver);
    }


}
