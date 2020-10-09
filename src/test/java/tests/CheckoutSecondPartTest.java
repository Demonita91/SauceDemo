package tests;

import org.testng.annotations.Test;

public class CheckoutSecondPartTest extends BaseTest {
    @Test
    public void cancelTheOrder() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        checkoutSecondPage.isPageOpened();
        checkoutSecondPage.clickCancel();
        productsPage.isPageOpened();
    }

    @Test
    public void finishTheOrder() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        checkoutSecondPage.isPageOpened();
        checkoutSecondPage.clickFinish();
        finishPage.isPageOpened();
    }
}
