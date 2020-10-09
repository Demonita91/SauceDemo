package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartAndDeleteIt() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, BaseTest.PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCartButton();
        cartPage.removeOneItemFromCart();
        Assert.assertEquals(0, cartPage.listOfProducts());
    }

    @Test
    public void addProductToCartAndClickContinueShopping() {
        loginPage.openPage();
        loginPage.login(BaseTest.USERNAME, BaseTest.PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.clickCartButton();
        cartPage.clickCheckout();
        checkoutPage.isPageOpened();
    }
}
