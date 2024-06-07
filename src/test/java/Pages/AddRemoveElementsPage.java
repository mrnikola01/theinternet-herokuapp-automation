package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {
    WebDriver driver;
    WebElement addElementButton;
    List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddElementButton() {
        return driver.findElement(By.cssSelector(".example button"));
    }

    public List<WebElement> getDeleteButtons() {
        return driver.findElements(By.cssSelector("#elements button"));
    }

    //--------------------------------------------------------------------

    public void clickOnAddElementButton() {
        getAddElementButton().click();
    }

    public void clickOnAllDeleteButtons() {
        for(WebElement button : getDeleteButtons()) button.click();
    }
}
