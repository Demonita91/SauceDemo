package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static sun.plugin.javascript.navig.JSType.URL;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final String URL = "https://www.saucedemo.com/";
    public static By ErrorMessageUserNameIsRequired = By.xpath("//h3[text()='Username is required']");
    public static By ErrorMessagePasswordIsRequired = By.xpath("//h3[text()='Password is required']");
    public static By ErrorMessageUsernameAndPasswordIsRequired = By.xpath("//h3[@data-test='error']");
    public static String emptyString = "";
    public static String incorrectUsername = "ghjd%$:125'?ikil";
    public static String incorrectPassword = "698$2%$:fhj'354787";
    public static String errorMessageUsernameIsRequired = "Epic sadface: Username is required";
    public static String errorMessagePasswordIsRequired = "Epic sadface: Password is required";
    public static String errorMessageUsernameAndPasswordDoNotMatch = "Epic sadface: Username and password do not match any user in this service";
    ;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void openPage() {
        driver.get(URL);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String errorMessageUserName() {
        String result = driver.findElement(ErrorMessageUserNameIsRequired).getText();
        return (result);
    }

    public String errorMessagePassword() {
        String result = driver.findElement(ErrorMessagePasswordIsRequired).getText();
        return (result);
    }

    public String errorMessageUsernameAndPassword() {
        String result = driver.findElement(ErrorMessageUsernameAndPasswordIsRequired).getText();
        return (result);
    }

}

