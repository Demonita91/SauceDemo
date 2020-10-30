package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    @Description("Проверка на добавление и удаление товара в корзину")
    public void addProductToCartAndDeleteIt() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, BaseTest.PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCartButton();
        cartPage.removeOneItemFromCart("Sauce Labs Fleece Jacket");
        Assert.assertEquals(0, cartPage.listOfProducts());
    }

    @Test
    @Description("Проверка на добавление товара в корзину и переход на следующую страницу")
    public void addProductToCartAndClickContinueShopping() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, BaseTest.PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        checkoutPage.isPageOpened();
    }
}
