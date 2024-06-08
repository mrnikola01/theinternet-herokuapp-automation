package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnKeyPressesPage() {
        homePage.clickOnLinkText("Key Presses");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/key_presses");
    }

    @Test(priority = 20)
    public void userCanInputKeyAndSeeResult() {
        homePage.clickOnLinkText("Key Presses");
        keyPressesPage.insertKey("A");

        Assert.assertEquals(keyPressesPage.getResultText(), "You entered: A");
    }

    @Test(priority = 30)
    public void userCanInputMoreKeysAndSeeLastKeyResult() {
        homePage.clickOnLinkText("Key Presses");
        keyPressesPage.insertKey("ABCGDFH");

        Assert.assertEquals(keyPressesPage.getResultText(), "You entered: H");
    }
}
