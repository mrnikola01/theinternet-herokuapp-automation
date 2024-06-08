package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    WebDriver driver;
    WebElement columnA;
    WebElement columnB;
    WebElement columnAHeader;
    WebElement columnBHeader;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getColumnA() {
        return driver.findElement(By.id("column-a"));
    }

    public WebElement getColumnB() {
        return driver.findElement(By.id("column-b"));
    }

    public String getColumnAHeaderText() {
        return getColumnA().findElement(By.tagName("header")).getText();
    }

    public String getColumnBHeaderText() {
        return getColumnB().findElement(By.tagName("header")).getText();
    }

    //--------------------------------------------------------------------

    public void dragAndDropAToB() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(getColumnA(), getColumnB()).perform();
    }

    public void dragAndDropBToA() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(getColumnB(), getColumnA()).perform();
    }
}
