package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckoutSecondPartTest extends BaseTest {
    @Test
    @Description("Проверка на отмену заказа")
    public void cancelTheOrder() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        checkoutSecondPage.isPageOpened();
        checkoutSecondPage.clickCancel();
        productsPage.isPageOpened();
    }

    @Test
    @Description("Проверка на заполнение данных и переход на страницу, с подтвержением оформленного заказа")
    public void finishTheOrder() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        checkoutSecondPage.isPageOpened();
        checkoutSecondPage.clickFinish();
        finishPage.isPageOpened();
    }
}
