package base.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    public void sendKeys(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

}