import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void shouldShowTheNameAndCostOfSauceLabsBackpack() {
        WebElement SauceLabsBackpackName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        WebElement SauceLabsBackpackCost = driver.findElement(By.xpath("//div[@id='inventory_container']/div/div[2]/div/div/div[3]/div"));
        System.out.println(SauceLabsBackpackName.getText() + " " + SauceLabsBackpackCost.getText());

    }

    public void shouldShowTheNameAndCostOfSauceLabsBikeLight() {
        WebElement SauceLabsBikeLightName = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        WebElement SauceLabsBikeLightCost = driver.findElement(By.xpath("//div/div[2]/div[3]/div"));
        System.out.println(SauceLabsBikeLightName.getText() + " " + SauceLabsBikeLightCost.getText());
    }

    public void shouldShowTheNameAndCostOfSauceLabsBoltTShirt() {
        WebElement SauceLabsBoltTShirtName = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        WebElement SauceLabsBoltTShirtCost = driver.findElement(By.xpath("//div/div[3]/div[3]/div"));
        System.out.println(SauceLabsBoltTShirtName.getText() + " " + SauceLabsBoltTShirtCost.getText());
    }

    public void shouldShowTheNameAndCostOfSauceLabsFleeceJacket() {
        WebElement SauceLabsFleeceJacketName = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        WebElement SauceLabsFleeceJacketCost = driver.findElement(By.xpath("//div/div[4]/div[3]/div"));
        System.out.println(SauceLabsFleeceJacketName.getText() + " " + SauceLabsFleeceJacketCost.getText());
    }

    public void shouldShowTheNameAndCostOfSauceLabsOnesie() {
        WebElement SauceLabsOnesieName = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        WebElement SauceLabsOnesieCost = driver.findElement(By.xpath("//div/div[5]/div[3]/div"));
        System.out.println(SauceLabsOnesieName.getText() + " " + SauceLabsOnesieCost.getText());
    }

    public void shouldShowTheNameAndCostOfTShirtRed() {
        WebElement TShirtRedName = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        WebElement TShirtRedCost = driver.findElement(By.xpath("//div/div[6]/div[3]/div"));
        System.out.println(TShirtRedName.getText() + " " + TShirtRedCost.getText());
    }

    @Test
    public void elementsTest() {
        driver.get("https://www.saucedemo.com/inventory.html");
        shouldShowTheNameAndCostOfSauceLabsBackpack();
        shouldShowTheNameAndCostOfSauceLabsBikeLight();
        shouldShowTheNameAndCostOfSauceLabsBoltTShirt();
        shouldShowTheNameAndCostOfSauceLabsFleeceJacket();
        shouldShowTheNameAndCostOfSauceLabsOnesie();
        shouldShowTheNameAndCostOfTShirtRed();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
