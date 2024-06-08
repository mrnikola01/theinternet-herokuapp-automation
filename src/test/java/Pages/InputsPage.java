package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage {
    WebDriver driver;
    WebElement numberInput;

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNumberInput() {
        return driver.findElement(By.cssSelector("input[type='number']"));
    }

    public String getNumberInputValue() {
        return getNumberInput().getAttribute("value");
    }

    //--------------------------------------------------------------------

    public void insertNumber(String number) {
        getNumberInput().clear();
        getNumberInput().sendKeys(number);
    }
}
