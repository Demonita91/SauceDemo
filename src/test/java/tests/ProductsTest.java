package tests;

import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {
    @Test
    public void productShouldBeAddedIntoCart() {

        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.productDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
    }
}
