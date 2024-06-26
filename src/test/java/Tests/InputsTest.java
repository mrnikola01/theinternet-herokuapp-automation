package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnInputsPage() {
        homePage.clickOnLinkText("Inputs");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/inputs");
    }

    @Test(priority = 20)
    public void userCanInputNumber() {
        homePage.clickOnLinkText("Inputs");
        inputsPage.insertNumber("123");

        Assert.assertEquals(inputsPage.getNumberInputValue(), "123");
    }

    @Test(priority = 30)
    public void userCantInputLetter() {
        homePage.clickOnLinkText("Inputs");
        inputsPage.insertNumber("a");

        Assert.assertEquals(inputsPage.getNumberInputValue(), "");
    }
}
