package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    public static String emptyString = "";
    public static String incorrectUsername = "ghjd%$:125'?ikil";
    public static String incorrectPassword = "698$2%$:fhj'354787";

    @Test
    public void loginShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(emptyString, BaseTest.PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void passwordShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, emptyString);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void loginAndPasswordShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(emptyString, emptyString);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void loginAndPasswordShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(incorrectUsername, incorrectPassword);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(incorrectUsername, PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void passwordShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, incorrectPassword);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

}
