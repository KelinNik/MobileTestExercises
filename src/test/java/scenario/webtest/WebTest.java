package scenario.webtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.Driver;

import static setup.PropertyFile.WEB;

@Test(groups = "web")
public class WebTest extends Driver {

    protected WebTest() throws Exception {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        Assert.assertTrue(driver().getTitle().equals("Internet Assigned Numbers Authority"));
        System.out.println("Site opening done");
    }
}