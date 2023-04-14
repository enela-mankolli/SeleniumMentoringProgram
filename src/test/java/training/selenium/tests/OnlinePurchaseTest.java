package training.selenium.tests;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.selenium.pages.*;
import training.selenium.utils.DriverFactory;
import training.selenium.utils.GlobalVariables;

import java.time.Duration;

public class OnlinePurchaseTest {

    public LoginPage loginPage;
    public ProductPage productPage;
    public YourCartPage yourCartPage;
    public CheckoutStepOnePage checkoutStepOnePage;
    public CheckoutStepTwoPage checkoutStepTwoPage;
    public CheckoutCompletePage checkoutCompletePage;

    public OnlinePurchaseTest() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        yourCartPage = new YourCartPage();
        checkoutStepOnePage = new CheckoutStepOnePage();
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }

    @BeforeMethod
    public void navigateToLoginPage() {
        DriverFactory.getDriver().get(GlobalVariables.url);
    }

    @Test
    public void buy2Products() {
        //1- login
        loginPage.login(GlobalVariables.standardUser, GlobalVariables.password);
      //  productPage.validateURL("https://www.saucedemo.com/inventory.html");
        WebDriverWait explicitWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html");

        //2- add products to cart
        productPage.addToCardProducts();

        //3- check number of chosen products
        productPage.validateNumberOfChosenProducts(2);
        productPage.clickShoppingCardBadge();
        yourCartPage.validateURL("https://www.saucedemo.com/cart.html");

        //4- validate products
        yourCartPage.validateProduct1Name("Sauce Labs Backpack");
        yourCartPage.validateProduct2Name("Sauce Labs Bike Light");
        yourCartPage.clickCheckoutButton();
        checkoutStepOnePage.validateURL("https://www.saucedemo.com/checkout-step-one.html");

        //5- CHECKOUT: YOUR INFORMATION
        checkoutStepOnePage.completeForm("Enela", "Mankolli", "1001");
        checkoutStepOnePage.clickContinueButton();
        checkoutStepTwoPage.validateURL("https://www.saucedemo.com/checkout-step-two.html");

        //6- CHECKOUT: OVERVIEW
       String totalPrice = checkoutStepTwoPage.getTotalPrice();
        Assert.assertEquals(totalPrice, "Total: $43.18");
        checkoutStepTwoPage.clickFinishButton();

        //7- CHECKOUT: COMPLETE!
        checkoutCompletePage.validateURL("https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(checkoutCompletePage.checkoutCompleteTitleElement.getText(),"THANK YOU FOR YOUR ORDER" );

    }


}
