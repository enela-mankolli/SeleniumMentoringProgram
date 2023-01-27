package training.selenium.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.selenium.pages.LoginPage;
import training.selenium.pages.ProductPage;
import training.selenium.utils.DriverFactory;





public class LoginTests {

    public LoginPage loginPage;
    public ProductPage productPage;

    public LoginTests() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @BeforeMethod
    public void navigate() {

        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @Test
    public void successfullyLogin() {
        loginPage.login("problem_user", "secret_sauce");
        productPage.validateURL("https://www.saucedemo.com/inventory.html");
        productPage.logout();
    }

    @Test
    public void unsuccessfullyLogin() {
        loginPage.login("problem_user", "secret_ sauce");
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        loginPage.checkInvalidLoginMessage(expectedErrorMessage);
    }

}
