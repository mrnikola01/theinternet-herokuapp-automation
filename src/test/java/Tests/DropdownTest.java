package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnDropdownPage() {
        homePage.clickOnLinkText("Dropdown");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/dropdown");
    }

    @Test(priority = 20)
    public void userCanSelectFirstOption() {
        homePage.clickOnLinkText("Dropdown");
        dropdownPage.selectFirstOption();

        Assert.assertEquals(dropdownPage.selectedOptionText(), "Option 1");
    }

    @Test(priority = 30)
    public void userCanSelectSecondOption() {
        homePage.clickOnLinkText("Dropdown");
        dropdownPage.selectSecondOption();

        Assert.assertEquals(dropdownPage.selectedOptionText(), "Option 2");
    }
}
