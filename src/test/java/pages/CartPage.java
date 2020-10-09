package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {

    public String endpoint = "cart.html";

    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" + "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" + "//div[@class='cart_quantity']";

    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final By CONTINUE_BUTTON = By.xpath("//a[text()='Continue Shopping']");
    private static final By removeButton = By.xpath("//div[@class='cart_list']/div[@class='cart_item'][1]//button[text()='REMOVE']");
    private static final By listOfProducts = By.xpath("//div[@class='cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + CHECKOUT_BUTTON);
        }
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

    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickContinueShopping() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void removeOneItemFromCart() {
        driver.findElement(removeButton).click();
    }

    public int listOfProducts() {
        List<WebElement> products = driver.findElements(listOfProducts);
        return products.size();
    }

}
