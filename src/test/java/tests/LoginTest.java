package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    public static String emptyString = "";
    public static String incorrectUsername = "ghjd%$:125'?ikil";
    public static String incorrectPassword = "698$2%$:fhj'354787";

    @Test
    @Description("Проверка на ошибку о не заполненном поле логин")
    public void loginShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(emptyString, BaseTest.PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    @Description("Проверка на ошибку о не заполненном поле пароль")
    public void passwordShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, emptyString);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    @Description("Проверка на ошибку о не заполненном поле пароль и логин")
    public void loginAndPasswordShouldBeEmpty() {
        loginPage.openPage();
        loginPage.login(emptyString, emptyString);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    @Description("Проверка на ошибку о не правильном логине и пароле")
    public void loginAndPasswordShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(incorrectUsername, incorrectPassword);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Description("Проверка на ошибку о не правильном логине")
    public void loginShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(incorrectUsername, PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    @Description("Проверка на ошибку о не правильном пароле")
    public void passwordShouldBeIncorrect() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, incorrectPassword);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

}
