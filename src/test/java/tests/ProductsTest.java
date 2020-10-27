package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Проверка на прохождение авторизации пользователя и добавления товара в корзину")
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
