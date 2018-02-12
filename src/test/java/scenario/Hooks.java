package scenario;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

@Test(groups = {"native", "web"})
public class Hooks extends Driver {
    /**
     * Required variables will be initialized by inherited constructor
     *
     * @throws Exception
     */
    Hooks() throws Exception {
        super();
    }

    @BeforeSuite(groups = "web")
    public void setUpWeb() throws Exception {
        prepareDriver();
    }

    @BeforeSuite(groups = "native")
    public void setUpNative() throws Exception {
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}