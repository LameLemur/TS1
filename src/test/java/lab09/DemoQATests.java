package lab09;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQATests extends TestCase {

    @Test
    public void openDemoQA() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com");

    }

    @Test
    public void openForm() {
        WebDriver driver = getDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        WebElement hobbiesCheckBox = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        firstName.sendKeys("Stepan");
        lastName.sendKeys("Stransky");
        email.sendKeys("stepan@pudy.cz");
        mobile.sendKeys("69 42069420");
        radioButton.sendKeys(" ");
        hobbiesCheckBox.click();

    }
}
