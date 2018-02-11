package scenario;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverSetupEmulator {
    AndroidDriver driver;

    /**
     * This method prepares
     * @throws MalformedURLException
     */
    @BeforeClass
    void prepareNative() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");

        File appDir = new File("C:\\Users\\Nikolai_Kelin\\Documents\\QALessons\\Mobile-Lessons");
        File app = new File(appDir, "ContactManager.apk");

        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
