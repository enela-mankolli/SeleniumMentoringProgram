package training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import training.selenium.utils.DriverFactory;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage() {
    }

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]/div[2]/div[@class='pricebar']/button")
    WebElement addToCartButtonProduct1;

    @FindBy(xpath = "//div[@class='inventory_list']/div[2]/div[2]/div[@class='pricebar']/button")
    WebElement addToCartButtonProduct2;

    public void addToCardProducts() {
        addToCartButtonProduct1.click();
        addToCartButtonProduct2.click();
    }

    public void logout() {
        DriverFactory.getDriver().findElement(By.id("react-burger-menu-btn")).click();
        DriverFactory.getDriver().findElement(By.id("logout_sidebar_link")).click();
    }

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement shoppingCardBadge;

    public void validateNumberOfChosenProducts(int expectedNrOfProducts) {
        int actualNrOfProducts = Integer.parseInt(shoppingCardBadge.getText());
        Assert.assertEquals(actualNrOfProducts, expectedNrOfProducts);
    }

    public void clickShoppingCardBadge() {
        shoppingCardBadge.click();
    }


}
