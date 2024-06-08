package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationSecurePage {
    WebDriver driver;
    WebElement title;
    WebElement message;
    WebElement logoutButton;

    public FormAuthenticationSecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement(By.cssSelector("#content h2"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.cssSelector("h4.subheader"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Logout"));
    }

    public String getTitleText() {
        return getTitle().getText();
    }

    public String getMessageText() {
        return getMessage().getText();
    }

    //--------------------------------------------------------------------

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }
}
