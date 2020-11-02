package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

public class CheckoutSecondPage extends BasePage {
    public static final String endpoint = "checkout-step-two.html";
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    public static final By FINISH_BUTTON = By.cssSelector(".btn_action");

    public CheckoutSecondPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutSecondPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + FINISH_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public void openPage() {
        driver.get(URL + endpoint);
        isPageOpened();
    }

    public void clickCancel() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

}


