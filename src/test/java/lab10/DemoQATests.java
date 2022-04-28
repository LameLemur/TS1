package lab10;

import lab09.TestCase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQATests extends TestCase {

    @Test
    public void endToEndFillForm() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement mainPageFormsDiv = driver.findElement(By.xpath("//h5[text()='Forms']//ancestor::div[@class='card mt-4 top-card']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(mainPageFormsDiv));
        jsClick(mainPageFormsDiv);


        WebElement formPagePracticeFromDiv = driver.findElement(By.xpath("//span[text()='Practice Form']//ancestor::li[@id='item-0']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(formPagePracticeFromDiv));
        jsClick(formPagePracticeFromDiv);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
}
