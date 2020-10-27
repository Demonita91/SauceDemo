package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    public static String emptyString = "";

    @Test
    @Description("Проверка на корректное заполнение данных и переход на следующу страницу")
    public void checkoutShouldBeFilledInAndClickContinue() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        checkoutSecondPage.isPageOpened();
    }

    @Test
    @Description("Проверка на ошибку о не заполненном поле имя")
    public void firstNameShouldBeEmpty() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(emptyString, LAST_NAME, POST_CODE);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getErrorText(), "Error: First Name is required");
    }

    @Test
    @Description("Проверка на ошибку о не заполненном поле фамилия")
    public void lastNameShouldBeEmpty() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, emptyString, POST_CODE);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getErrorText(), "Error: Last Name is required");
    }

    @Test
    @Description("Проверка на ошибку о не заполненном поле индекс")
    public void zipCodeShouldBeEmpty() {
        checkoutPage.openPage();
        checkoutPage.enterCheckoutInformation(FIRST_NAME, LAST_NAME, emptyString);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getErrorText(), "Error: Postal Code is required");
    }

}
