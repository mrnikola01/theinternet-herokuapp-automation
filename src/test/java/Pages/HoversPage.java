package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {
    WebDriver driver;
    List<WebElement> images;
    List<WebElement> names;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getImages() {
        return driver.findElements(By.className("figure"));
    }

    public List<WebElement> getNames() {
        return driver.findElements(By.cssSelector(".figcaption h5"));
    }

    public String getFirstUserName() {
        return getNames().get(0).getText();
    }

    public String getSecondUserName() {
        return getNames().get(1).getText();
    }

    public String getThirdUserName() {
        return getNames().get(2).getText();
    }

    //--------------------------------------------------------------------

    public void hoverOnImage(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getImages().get(index)).perform();
    }
}
