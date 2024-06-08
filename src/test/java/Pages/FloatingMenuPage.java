package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingMenuPage {
    WebDriver driver;
    WebElement menu;

    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMenu() {
        return driver.findElement(By.id("menu"));
    }

    //--------------------------------------------------------------------

    public void scrollToPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
