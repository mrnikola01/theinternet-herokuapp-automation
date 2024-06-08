package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnFloatingMenuPage() {
        homePage.clickOnLinkText("Floating Menu");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu");
    }

    @Test(priority = 20)
    public void userCanSeeFloatingMenuWhenScroll() {
        homePage.clickOnLinkText("Floating Menu");
        floatingMenuPage.scrollToPageEnd();

        Assert.assertTrue(floatingMenuPage.getMenu().isDisplayed());
    }
}
