package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 10)
    public void userIsOnDragAndDropPage() {
        homePage.clickOnLinkText("Drag and Drop");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test(priority = 20)
    public void userCanDragAndDropAToB() {
        homePage.clickOnLinkText("Drag and Drop");
        dragAndDropPage.dragAndDropAToB();

        Assert.assertEquals(dragAndDropPage.getColumnBHeaderText(), "A");
    }

    @Test(priority = 30)
    public void userCanDragAndDropBToA() {
        homePage.clickOnLinkText("Drag and Drop");
        dragAndDropPage.dragAndDropBToA();

        Assert.assertEquals(dragAndDropPage.getColumnAHeaderText(), "B");
    }
}
