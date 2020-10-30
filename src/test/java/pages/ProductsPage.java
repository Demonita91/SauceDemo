package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

public class ProductsPage extends BasePage {

    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";

    public static final By PRODUCTS_LABEL = By.cssSelector(".product_label");
    public static final By CART_BUTTON = By.cssSelector(".shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + PRODUCTS_LABEL);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }

    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }
}
