package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormAuthenticationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    public void loginWithCredentials(String username, String password) {
        homePage.clickOnLinkText("Form Authentication");
        formAuthenticationLoginPage.insertUsername(username);
        formAuthenticationLoginPage.insertPassword(password);
        formAuthenticationLoginPage.clickOnLoginButton();
    }

    @Test(priority = 10)
    public void userIsOnLoginPage() {
        homePage.clickOnLinkText("Form Authentication");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test(priority = 20)
    public void userIsOnSecurePage() {
        loginWithCredentials("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @Test(priority = 30)
    public void userCanLogIn() {
        loginWithCredentials("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(formAuthenticationSecurePage.getTitleText(), "Secure Area");
        Assert.assertEquals(formAuthenticationSecurePage.getMessageText(), "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertTrue(formAuthenticationSecurePage.getLogoutButton().isDisplayed());
    }

    @Test(priority = 40)
    public void userCanLogOut() {
        loginWithCredentials("tomsmith", "SuperSecretPassword!");
        formAuthenticationSecurePage.clickOnLogoutButton();

        Assert.assertEquals(formAuthenticationLoginPage.getTitleText(), "Login Page");
        Assert.assertTrue(formAuthenticationLoginPage.getUsernameInput().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getPasswordInput().isDisplayed());
    }

    @Test(priority = 50)
    public void userCannotLogInInvalidUsername() {
        loginWithCredentials("invalidUsername", "SuperSecretPassword!");

        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessageText().contains("Your username is invalid!"));
    }

    @Test(priority = 60)
    public void userCannotLogInInvalidPassword() {
        loginWithCredentials("tomsmith", "invalidPassword");

        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessageText().contains("Your password is invalid!"));
    }
}
