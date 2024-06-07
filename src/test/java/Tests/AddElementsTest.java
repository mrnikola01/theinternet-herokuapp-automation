package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddElementsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void userCanAddElement() {
        homePage.clickOnLinkText("Add/Remove Elements");
        addRemoveElementsPage.clickOnAddElementButton();

        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 1);
    }

    @Test
    public void userCanAddMultipleElements() {
        homePage.clickOnLinkText("Add/Remove Elements");
        for(int i = 0; i < 5; i++) addRemoveElementsPage.clickOnAddElementButton();

        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 5);
    }
}
