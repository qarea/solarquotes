package mobileTesting;

import base.BaseTest;
import base.pageObjects.HomePage;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

import static com.applitools.eyes.visualgrid.model.DeviceName.iPhone_X;
import static com.applitools.eyes.visualgrid.model.ScreenOrientation.LANDSCAPE;

public class IPhoneXLandscape extends BaseTest {

    @Test
    public void iPhoneXLandscapeTest() {

        eyes.setConfiguration(configuration.addDeviceEmulation(iPhone_X, LANDSCAPE)
                .setBatch(new BatchInfo("Solarquotes - iPhoneX_Landscape orientation")));

        eyes.open(webDriver, "Solarquotes Web App", "Adding 4 digit number into a form and hitting submit",
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
