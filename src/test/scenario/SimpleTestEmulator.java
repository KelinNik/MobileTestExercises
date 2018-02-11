package scenario;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTestEmulator extends DriverSetupEmulator {

    /**
     * Prepare driver to run test(s)
     */
    @BeforeClass
    public void setUp() throws Exception {
        prepareNative();
    }


    /**
     * This simple test just click on button 'Add contact'
     */
    @Test(description = "simple test for button")
    public void SimplestTest() {
//      String app_package_name = "com.example.android.contactmanager:id/";
//      By add_btn = By.id(app_package_nameckage_name + "addContactButton");

//      By add_btn = By.xpath("//android.widget.Button[@content-desc='Add Contact']");

        By add_btn = By.className("android.widget.Button");

        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    /**
     * Close driver on all tests completion
     */
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}