package LinkSpringer;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        List<List<String>> results = new ArrayList<>();

        new MainPage(driver).
                clickAdvancedSearch().
                searchFillAllWords("Page Object Model").
                searchFillLeastWords("Sellenium Testing").
                fillStartYear("2022").
                fillEndYear("2022").
                clickSearch().
                clickArticles().
                clickFirstArticle().
                getInfo(results).
                goBack().
                clickSecondArticle().
                getInfo(results).
                goBack().
                clickThirdArticle().
                getInfo(results).
                goBack().
                clickFourthArticle().
                getInfo(results);
    }
}
