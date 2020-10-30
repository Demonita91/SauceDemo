package tests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutSecondPage checkoutSecondPage;
    FinishPage finishPage;
    MenuPage menuPage;

    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Kate";
    public static final String LAST_NAME = "Doll";
    public static final String POST_CODE = "200586 kl";

    @BeforeMethod
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutSecondPage = new CheckoutSecondPage(driver);
        finishPage = new FinishPage(driver);
        menuPage = new MenuPage(driver);
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
