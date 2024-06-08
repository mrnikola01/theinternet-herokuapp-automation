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

    @Test
    public void userCanSelectFirstOption() {
        homePage.clickOnLinkText("Dropdown");
        dropdownPage.selectFirstOption();

        Assert.assertEquals(dropdownPage.selectedOptionText(), "Option 1");
    }

    @Test
    public void userCanSelectSecondOption() {
        homePage.clickOnLinkText("Dropdown");
        dropdownPage.selectSecondOption();

        Assert.assertEquals(dropdownPage.selectedOptionText(), "Option 2");
    }
}
