package browsersTesting;

import base.BaseTest;
import base.pageObjects.HomePage;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

import static com.applitools.eyes.selenium.BrowserType.SAFARI;

public class SafariTest extends BaseTest {

    private final static BatchInfo BATCH = new BatchInfo("Solarquotes - Safari browser testing");

    @Test
    public void safariTest() {

        eyes.setConfiguration(configuration.setBatch(BATCH).addBrowser(1024, 768, SAFARI));

        eyes.open(webDriver, "Solarisquotes Web App",
                "Adding 4 digit number into a form and hitting submit",
                new RectangleSize(1200, 600));

        openHomePage();

        eyes.check(Target.window().fully().withName("solarquotes home page"));

        HomePage homePage = new HomePage(webDriver);
        homePage.fillPostcode();
        homePage.submit();

        eyes.check(Target.window().fully().withName("solarquotes home page").layout());
        eyes.closeAsync();

    }

}
