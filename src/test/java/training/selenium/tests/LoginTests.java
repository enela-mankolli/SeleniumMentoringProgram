package training.selenium.tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.selenium.pages.LoginPage;
import training.selenium.pages.ProductPage;
import training.selenium.utils.DriverFactory;
import training.selenium.utils.GlobalVariables;

import java.time.Duration;

public class LoginTests {

    public LoginPage loginPage;
    public ProductPage productPage;

    public LoginTests() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @BeforeMethod
    public void navigate() {

        DriverFactory.getDriver().get(GlobalVariables.url);
    }

    @Test
    public void successfullyLogin() {
        loginPage.login(GlobalVariables.problemUser,GlobalVariables.password);
        WebDriverWait explicitWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html" );
        productPage.logout();
    }

    @Test
    public void unsuccessfullyLogin() {
        loginPage.login(GlobalVariables.problemUser, GlobalVariables.invalidPassword);
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        loginPage.checkInvalidLoginMessage(expectedErrorMessage);
    }

}
