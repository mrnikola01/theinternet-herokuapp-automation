package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;
    List<WebElement> linkTexts;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getLinkTexts() {
        return driver.findElements(By.cssSelector("#content ul li a"));
    }

    //--------------------------------------------------------------------

    public void clickOnLinkText(String linkText) {
        for(WebElement link : getLinkTexts()) {
            if(link.getText().equals(linkText)) {
                link.click();
                break;
            }
        }
    }
}
