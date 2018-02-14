package scenario;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

@Test(groups = {"web", "native"})
public class Hooks extends Driver {
    /**
     * Required variables will be initialized by inherited constructor
     *
     * @throws Exception
     */
    Hooks() throws Exception {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)", groups = {"web", "native"})
    public void setUp() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}