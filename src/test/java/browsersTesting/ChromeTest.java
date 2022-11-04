package browsersTesting;

import base.BaseTest;
import base.pageObjects.HomePage;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

import static com.applitools.eyes.selenium.BrowserType.CHROME;

public class ChromeTest extends BaseTest {

    private final static BatchInfo BATCH = new BatchInfo("Solarquotes - Chrome browser testing");

    @Test
    public void chromeTest() {

        eyes.setConfiguration(configuration.setBatch(BATCH).addBrowser(800, 600, CHROME));

        eyes.open( webDriver,"Solarquotes Web App", "Adding 4 digit number into a form and hitting submit",
                new RectangleSize(1200, 600));

        openHomePage();

        eyes.check(Target.window().fully().withName("solarquotes home page"));

        new HomePage(webDriver)
                .fillPostcode()
                .submit();

        eyes.check(Target.window().fully().withName("solarquotes home page").layout());
        eyes.closeAsync();

    }
}