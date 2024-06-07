package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage {
    WebDriver driver;
    WebElement box;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBox() {
        return driver.findElement(By.id("hot-spot"));
    }

    public Alert getAlert() {
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    //--------------------------------------------------------------------

    public void leftClickOnBox() {
        getBox().click();
    }

    public void rightClickOnBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(getBox()).perform();
    }

    public void clickOnAlertButton() {
        getAlert().accept();
    }
}
