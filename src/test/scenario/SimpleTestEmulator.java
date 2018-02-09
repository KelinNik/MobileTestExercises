package scenario;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTestEmulator extends DriverSetupEmulator {

    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareNative();
    }

    @Test
    /**
     * This simple test just click on button 'Add contact'
     */
    public void SimplestTest() {
//      String app_package_name = "com.example.android.contactmanager:id/";
//      By add_btn = By.id(app_package_nameckage_name + "addContactButton");

//      By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        By add_btn = By.className("android.widget.Button");

        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }
}