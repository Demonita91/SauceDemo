package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    public static String emptyString = "";

    @Test
    public void checkoutShouldBeFilledInAndClickContinue() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        checkoutSecondPage.isPageOpened();
    }

    @Test
    public void firstNameShouldBeEmpty() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(emptyString, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getErrorText(), "Error: First Name is required");
    }

    @Test
    public void lastNameShouldBeEmpty() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, emptyString, POST_CODE);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getErrorText(), "Error: Last Name is required");
    }

    @Test
    public void zipCodeShouldBeEmpty() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, emptyString);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getErrorText(), "Error: Postal Code is required");
    }

}
