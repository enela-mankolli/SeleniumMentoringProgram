package training.selenium.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import training.selenium.pages.LoginPage;
import training.selenium.pages.ProductPage;
import training.selenium.utils.DriverFactory;
import training.selenium.utils.GlobalVariables;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductsTests {

    public LoginPage loginPage;
    public ProductPage productPage;

    public ProductsTests() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    List<String> expectedProducts = Arrays.asList(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie",
            "Test.allTheThings() T-Shirt (Red)");

    @Test
    public void verifyProducts() {
        DriverFactory.getDriver().get(GlobalVariables.url);
        loginPage.login(GlobalVariables.standardUser, GlobalVariables.password);
        WebDriverWait explicitWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html");
        List<String> actualProductsName = productPage.getProductsName();
        Assert.assertEquals(actualProductsName, expectedProducts);
    }
}