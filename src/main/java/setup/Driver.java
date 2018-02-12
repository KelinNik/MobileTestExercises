package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Initialize a driver with test properties
 */
public class Driver extends TestProperties {
    private static AppiumDriver singleDriver = null;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    private static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    private static String TEST_PLATFORM;
    private static String DRIVER;

    // Constructor initializes properties on driver creation
    public Driver() throws Exception {
        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
    }

    protected AppiumDriver driver() throws Exception {
        if (singleDriver == null) prepareDriver();
        return singleDriver;
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // default Android emulator
        browserName = "Chrome";
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driver for local Appium server with capabilities have been set
        if (singleDriver == null) {
            singleDriver = new AppiumDriver(new URL(DRIVER), capabilities);
        }
    }
}
