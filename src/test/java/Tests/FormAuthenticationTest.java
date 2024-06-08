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

    @Test
    public void userCanLogIn() {
        loginWithCredentials("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(formAuthenticationSecurePage.getTitleText(), "Secure Area");
        Assert.assertEquals(formAuthenticationSecurePage.getMessageText(), "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertTrue(formAuthenticationSecurePage.getLogoutButton().isDisplayed());
    }

    @Test
    public void userCanLogOut() {
        loginWithCredentials("tomsmith", "SuperSecretPassword!");
        formAuthenticationSecurePage.clickOnLogoutButton();

        Assert.assertEquals(formAuthenticationLoginPage.getTitleText(), "Login Page");
        Assert.assertTrue(formAuthenticationLoginPage.getUsernameInput().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getPasswordInput().isDisplayed());
    }

    @Test
    public void userCannotLogInInvalidUsername() {
        loginWithCredentials("invalidUsername", "SuperSecretPassword!");

        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessageText().contains("Your username is invalid!"));
    }

    @Test
    public void userCannotLogInInvalidPassword() {
        loginWithCredentials("tomsmith", "invalidPassword");

        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessage().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getLoginButton().isDisplayed());
        Assert.assertTrue(formAuthenticationLoginPage.getErrorMessageText().contains("Your password is invalid!"));
    }
}
