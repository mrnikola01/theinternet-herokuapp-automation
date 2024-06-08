package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationLoginPage {
    WebDriver driver;
    WebElement title;
    WebElement errorMessage;
    WebElement usernameInput;
    WebElement passwordInput;
    WebElement loginButton;

    public FormAuthenticationLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement(By.cssSelector("#content h2"));
    }

    public String getTitleText() {
        return getTitle().getText();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.id("flash"));
    }

    public String getErrorMessageText() {
        return getErrorMessage().getText();
    }

    public WebElement getUsernameInput() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("#login button[type='submit']"));
    }

    //--------------------------------------------------------------------

    public void insertUsername(String username) {
        getUsernameInput().clear();
        getUsernameInput().sendKeys(username);
    }

    public void insertPassword(String password) {
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
}
