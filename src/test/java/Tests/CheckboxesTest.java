package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnCheckboxesPage() {
        homePage.clickOnLinkText("Checkboxes");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/checkboxes");
    }

    @Test(priority = 20)
    public void userCanSelectCheckbox() {
        homePage.clickOnLinkText("Checkboxes");
        checkboxesPage.clickOnFirstCheckbox();

        Assert.assertTrue(checkboxesPage.getCheckboxes().get(0).isSelected());
    }

    @Test(priority = 30)
    public void userCanSelectAllCheckboxes() {
        homePage.clickOnLinkText("Checkboxes");
        checkboxesPage.clickOnSecondCheckbox();
        checkboxesPage.clickOnFirstCheckbox();
        checkboxesPage.clickOnSecondCheckbox();

        Assert.assertTrue(checkboxesPage.getCheckboxes().get(0).isSelected());
        Assert.assertTrue(checkboxesPage.getCheckboxes().get(1).isSelected());
    }

    @Test(priority = 40)
    public void userCanDeselectCheckbox() {
        homePage.clickOnLinkText("Checkboxes");
        checkboxesPage.clickOnSecondCheckbox();

        Assert.assertFalse(checkboxesPage.getCheckboxes().get(1).isSelected());
    }

    @Test(priority = 50)
    public void userCanDeselectAllCheckboxes() {
        homePage.clickOnLinkText("Checkboxes");
        checkboxesPage.clickOnFirstCheckbox();
        checkboxesPage.clickOnSecondCheckbox();
        checkboxesPage.clickOnFirstCheckbox();

        Assert.assertFalse(checkboxesPage.getCheckboxes().get(0).isSelected());
        Assert.assertFalse(checkboxesPage.getCheckboxes().get(1).isSelected());
    }
}
