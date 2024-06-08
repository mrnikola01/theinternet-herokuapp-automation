package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage {
    WebDriver driver;
    WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDropdown() {
        return driver.findElement(By.id("dropdown"));
    }

    public String selectedOptionText() {
        return selectDropdown().getFirstSelectedOption().getText();
    }

    //--------------------------------------------------------------------

    public Select selectDropdown() {
        return new Select(getDropdown());
    }

    public void selectFirstOption() {
        selectDropdown().selectByVisibleText("Option 1");
    }

    public void selectSecondOption() {
        selectDropdown().selectByVisibleText("Option 2");
    }
}
