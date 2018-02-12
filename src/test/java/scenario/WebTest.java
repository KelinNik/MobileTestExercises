package scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "web")
public class WebTest extends Driver {

    protected WebTest() throws Exception {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
//        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        Assert.assertTrue(driver().findElement(By.className("homepage")).isDisplayed());
        System.out.println("Site opening done");
    }
}