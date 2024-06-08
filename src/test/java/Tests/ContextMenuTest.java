package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnContextMenuPage() {
        homePage.clickOnLinkText("Context Menu");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/context_menu");
    }

    @Test(priority = 20)
    public void alertAppearsOnRightClick() {
        homePage.clickOnLinkText("Context Menu");
        contextMenuPage.rightClickOnBox();

        Assert.assertEquals(contextMenuPage.getAlert().getText(), "You selected a context menu");
        contextMenuPage.clickOnAlertButton();
    }

    @Test(priority = 30)
    public void alertNotAppearsOnLeftClick() {
        homePage.clickOnLinkText("Context Menu");
        contextMenuPage.leftClickOnBox();

        Assert.assertFalse(contextMenuPage.isAlertPresent());
    }
}
