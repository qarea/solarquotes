package base;

import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected VisualGridRunner runner;
    protected Eyes eyes;
    private final static String API_KEY = "uJhXRDtbRHfVHSlJr2XB5w2KvQq0Y7rpoCyKEjQ106UMc110";
    public WebDriver webDriver;
    protected Configuration configuration;


    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        runner = new VisualGridRunner();
        eyes = new Eyes(runner);
        configuration = eyes.getConfiguration();
        configuration.setApiKey(API_KEY);
    }


    protected void openHomePage(){
        webDriver.get("https://www.solarquotes.com.au/");
    }

    @AfterMethod
    public void quitDriver(){
        webDriver.quit();
    }

    @AfterMethod
    public void closeEyes(){
        if (eyes != null)
            eyes.abortAsync();

        try {
            if (runner != null) {
                TestResultsSummary allTestResults = runner.getAllTestResults();
                System.out.println(allTestResults);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
