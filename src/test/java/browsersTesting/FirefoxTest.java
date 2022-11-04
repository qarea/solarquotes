package browsersTesting;

import base.BaseTest;
import base.pageObjects.HomePage;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

import static com.applitools.eyes.selenium.BrowserType.FIREFOX;

public class FirefoxTest extends BaseTest {
    private final static BatchInfo BATCH = new BatchInfo("Solarquotes - Firefox browser testing");

    @Test
    public void firefoxTest() {

        eyes.setConfiguration(configuration.setBatch(BATCH).addBrowser(1600, 1200, FIREFOX));

        eyes.open(webDriver, "Solarisquotes Web App", "Adding 4 digit number into a form and hitting submit",
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