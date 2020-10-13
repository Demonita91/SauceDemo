package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MenuPage extends BasePage {


    public static final By BUTTON_OPEN_ITEM = By.cssSelector(".bm-burger-button");
    public static final By ALL_ITEMS = By.id("inventory_sidebar_link");
    public static final By ABOUT = By.id("about_sidebar_link");
    public static final By LOGOUT = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");
    public String endpoint = "checkout-step-one.html";

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + LOGOUT);
        }
        return this;
    }

    public MenuPage openMenu() {
        driver.findElement(BUTTON_OPEN_ITEM).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(RESET_APP_STATE));
        return this;
    }

    public MenuPage allItemsClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALL_ITEMS));
        driver.findElement(ALL_ITEMS).click();
        return this;
    }

    public MenuPage aboutClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT));
        driver.findElement(ABOUT).click();
        return this;
    }

    public LoginPage logOutClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));
        driver.findElement(LOGOUT).click();
        return new LoginPage(driver);
    }

    public MenuPage resetAppStateClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RESET_APP_STATE));
        driver.findElement(RESET_APP_STATE).click();
        return this;
    }
}
