package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage {
    WebDriver driver;
    WebElement keyInput;
    WebElement result;

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getKeyInput() {
        return driver.findElement(By.id("target"));
    }

    public WebElement getResult() {
        return driver.findElement(By.id("result"));
    }

    public String getResultText() {
        return getResult().getText();
    }

    //--------------------------------------------------------------------

    public void insertKey(String key) {
        getKeyInput().clear();
        getKeyInput().sendKeys(key);
    }
}
