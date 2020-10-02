package tests;

import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    @Test
    public void checkoutShouldBeFilledIn(){
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME,LAST_NAME,POST_CODE);

    }
}
