package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {

    public String endpoint = "cart.html";

    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" + "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" + "//div[@class='cart_quantity']";
    String removeButton = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" + "//button[text()='REMOVE']";

    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final By CONTINUE_BUTTON = By.xpath("//a[text()='Continue Shopping']");
    private static final By listOfProducts = By.xpath("//div[@class='cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Cart page was opened")
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + CHECKOUT_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public CartPage openPage() {
        driver.get(URL + endpoint);
        return this;
    }

    public void productDetailsShouldBeLike(String productName, String quantity, String price) {
        String actualPrice = driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
        String actualQuantity = driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
        assertEquals(actualPrice, price, "Price is not correct");
        assertEquals(actualQuantity, quantity, "Price is not correct");
    }

    @Step("Click on Checkout button")
    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Click on Continue button")
    public void clickContinueShopping() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Click on Remove button")
    public void removeOneItemFromCart(String productName) {
        driver.findElement(By.xpath(String.format(removeButton,productName))).click();
    }

    public int listOfProducts() {
        List<WebElement> products = driver.findElements(listOfProducts);
        return products.size();
    }

}
