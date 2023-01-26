package training.selenium.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {

    @FindBy(css = "div[id='checkout_complete_container'] h2")
    WebElement checkoutCompleteTitleElement;

    public void validateMessage(String message) {
        Assert.assertEquals(checkoutCompleteTitleElement.getText(), message);
    }
}
