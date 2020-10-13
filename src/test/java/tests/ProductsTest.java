package tests;

import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void productShouldBeAddedIntoCart() {

        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .isPageOpened()
                .productDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
    }
}
