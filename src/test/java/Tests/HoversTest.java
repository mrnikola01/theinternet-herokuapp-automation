package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void userCanHoverOnFirstImage() {
        homePage.clickOnLinkText("Hovers");
        hoversPage.hoverOnImage(0);

        Assert.assertEquals(hoversPage.getFirstUserName(), "name: user1");
    }

    @Test
    public void userCanHoverOnSecondImage() {
        homePage.clickOnLinkText("Hovers");
        hoversPage.hoverOnImage(1);

        Assert.assertEquals(hoversPage.getSecondUserName(), "name: user2");
    }

    @Test
    public void userCanHoverOnThirdImage() {
        homePage.clickOnLinkText("Hovers");
        hoversPage.hoverOnImage(2);

        Assert.assertEquals(hoversPage.getThirdUserName(), "name: user3");
    }
}
