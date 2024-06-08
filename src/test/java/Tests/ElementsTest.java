package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnAddOrRemoveElementsPage() {
        homePage.clickOnLinkText("Add/Remove Elements");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(priority = 20)
    public void userCanAddMultipleElements() {
        homePage.clickOnLinkText("Add/Remove Elements");
        for(int i = 0; i < 5; i++) addRemoveElementsPage.clickOnAddElementButton();

        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 5);
    }

    @Test(priority = 30)
    public void userCanRemoveElement() {
        homePage.clickOnLinkText("Add/Remove Elements");
        addRemoveElementsPage.clickOnAddElementButton();
        addRemoveElementsPage.clickOnAllDeleteButtons();

        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 0);

    }

    @Test(priority = 40)
    public void userCanRemoveMultipleElements() {
        homePage.clickOnLinkText("Add/Remove Elements");
        for(int i = 0; i < 5; i++) addRemoveElementsPage.clickOnAddElementButton();
        for(int i = 0; i < 5; i++) addRemoveElementsPage.clickOnAllDeleteButtons();

        Assert.assertEquals(addRemoveElementsPage.getDeleteButtons().size(), 0);
    }
}
