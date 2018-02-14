package scenario.nativetest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

@Test(groups = "native")
public class NativeTest extends Driver {
    protected NativeTest() throws Exception {
        super();
    }

    @Test(description = "Just click on button 'Add contact'")
    public void nativeTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        assert driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Contact Name\"]"))
                .getText().equals("Contact Name")
                : "Not equals";
        assert driver().findElement(By.id("com.example.android.contactmanager:id/contactNameEditText"))
                .isDisplayed()
                : "Not displayed";
        assert driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Contact Phone\"]"))
                .getText().equals("Contact Phone")
                : "Not equals";
        assert driver().findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText"))
                .isDisplayed()
                : "Not displayed";
    }
}