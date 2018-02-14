package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static setup.PropertyFile.NATIVE;
import static setup.PropertyFile.WEB;

/**
 * Initialize a driver with test properties
 */
public class Driver extends TestProperties {
    private static AppiumDriver singleDriver = null;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    public static String AUT; // (mobile) app under testing
    public static String SUT; // site under testing
    public static String TEST_PLATFORM;
    public static String DRIVER;
    public static String DEVICE_NAME;




    // Constructor initializes properties on driver creation
    public Driver() throws Exception {
//        currentPropertiesFile = NATIVE.path;
    //    currentPropertiesFile = WEB.path;
        AUT = getProp("aut");
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("deviceName");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        // Setup type of application: mobile, webtest (or hybrid)
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

    protected AppiumDriver driver() throws Exception {
        if (singleDriver == null) prepareDriver();
        return singleDriver;
    }
}
