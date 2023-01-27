package training.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import training.selenium.pages.LoginPage;
import training.selenium.pages.ProductPage;
import training.selenium.utils.DriverFactory;
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
        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");
        productPage.validateURL("https://www.saucedemo.com/inventory.html");

        List<String> actualProductsName = productPage.getProductsName();

        Assert.assertEquals(actualProductsName, expectedProducts);
    }
}