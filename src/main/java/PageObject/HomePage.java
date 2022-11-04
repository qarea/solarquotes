package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private final By placeholderPostcode = By.xpath("//div[@class='form-body']//input[@placeholder='Enter Your Postcode']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage fillPostcode(){
        sendKeys(placeholderPostcode, "7878");
        return this;
    }

    public HomePage submit(){
        sendKeys(placeholderPostcode, "\n");
        return this;
    }

}
