package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void loginShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(LoginPage.emptyString, BaseTest.PASSWORD);
        assertEquals(LoginPage.errorMessageUsernameIsRequired, loginPage.errorMessageUserName(), "Epic sadface: Username is required");
    }

    @Test
    public void passwordShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, LoginPage.emptyString);
        assertEquals(LoginPage.errorMessagePasswordIsRequired, loginPage.errorMessagePassword(), "Epic sadface: Password is required");
    }

    @Test
    public void loginAndPasswordShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(LoginPage.emptyString, LoginPage.emptyString);
        assertEquals(LoginPage.errorMessageUsernameIsRequired, loginPage.errorMessageUserName(), "Epic sadface: Username is required");
    }

    @Test
    public void loginAndPasswordShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(LoginPage.incorrectUsername, LoginPage.incorrectPassword);
        assertEquals(LoginPage.errorMessageUsernameAndPasswordDoNotMatch, loginPage.errorMessageUsernameAndPassword(), "Username and password do not match any user in this service");
    }

    @Test
    public void loginShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(LoginPage.incorrectUsername, BaseTest.PASSWORD);
        assertEquals(LoginPage.errorMessageUsernameAndPasswordDoNotMatch, loginPage.errorMessageUsernameAndPassword(), "Username and password do not match any user in this service");
    }

    @Test
    public void passwordShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, LoginPage.incorrectPassword);
        assertEquals(LoginPage.errorMessageUsernameAndPasswordDoNotMatch, loginPage.errorMessageUsernameAndPassword(), "Username and password do not match any user in this service");
    }

}
