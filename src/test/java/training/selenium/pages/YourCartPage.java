package training.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YourCartPage extends BasePage{

    @FindBy(xpath = "//div[@class='cart_list']/div[@class='cart_item'][1]//div[@class='inventory_item_name']")
    WebElement productName1Webelement;

    @FindBy(xpath = "//div[@class='cart_list']/div[@class='cart_item'][2]//div[@class='inventory_item_name']")
    WebElement productName2Webelement;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public void validateProduct1Name(String expectedName) {
        String productName1 = productName1Webelement.getText();
        Assert.assertEquals(productName1, expectedName);
    }

    public void validateProduct2Name(String expectedName) {
        String productName2 = productName2Webelement.getText();
        Assert.assertEquals(productName2, expectedName);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
