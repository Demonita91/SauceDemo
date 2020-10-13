package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POST_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector("[value=CONTINUE]");
    public static final By ERROR = By.cssSelector("[data-test=error]");
    public static final By CANCEL = By.cssSelector(".cart_cancel_link");
    public String endpoint = "checkout-step-one.html";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + CONTINUE_BUTTON);
        }
        return this;
    }

    public void openPage() {
        driver.get(URL + endpoint);
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(POST_CODE_INPUT).sendKeys(postCode);
    }

    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }


}