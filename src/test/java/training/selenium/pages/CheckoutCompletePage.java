package training.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {
    @FindBy(css = "div[id='checkout_complete_container'] h2")
    public WebElement checkoutCompleteTitleElement;
}
