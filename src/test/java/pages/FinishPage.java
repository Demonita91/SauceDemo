package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

public class FinishPage extends BasePage {
    public String endpoint = "checkout-complete.html";

    public static final By THANK_YOU_FOR_ORDER = By.cssSelector(".complete-header");
    public static final By ORDER_WILL_ARRIVE = By.cssSelector(".complete-text");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public FinishPage openPage() {
        driver.get(URL + endpoint);
        isPageOpened();
        return this;
    }

    public FinishPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_WILL_ARRIVE));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + ORDER_WILL_ARRIVE);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
