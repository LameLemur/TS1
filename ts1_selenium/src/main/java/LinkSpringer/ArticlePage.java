package LinkSpringer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ArticlePage {

    private final WebDriver driver;
    @FindBy(xpath = "//h1[@class='c-article-title']")
    private WebElement title;
    @FindBy(xpath = "//span[@class='c-bibliographic-information__value']//ancestor::li/p[text()='Published']//time")
    private WebElement publishedTime;
    @FindBy(xpath = "//meta[@name='prism.doi']")
    private WebElement doi;


    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public SearchPage goBack() {
        driver.navigate().back();
        return new SearchPage(driver);
    }

    public ArticlePage getInfo(List<List<String>> results) {

        List<String> result = new ArrayList<>();
        result.add(title.getText());
        result.add(publishedTime.getText());
        result.add(doi.getAttribute("content"));
        results.add(result);
        return this;
    }
}
