package mobileTesting;

import base.BaseTest;
import base.pageObjects.HomePage;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.fluent.Target;
import org.testng.annotations.Test;

import static com.applitools.eyes.visualgrid.model.DeviceName.Pixel_2;
import static com.applitools.eyes.visualgrid.model.ScreenOrientation.PORTRAIT;

public class Pixel2Portrait extends BaseTest {

    @Test
    public void pixel2PortraitTest() {

        eyes.setConfiguration(configuration.addDeviceEmulation(Pixel_2, PORTRAIT)
                .setBatch(new BatchInfo("Solarquotes - Pixel2_Portrait orientation")));

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
