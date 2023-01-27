package training.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutStepTwoPage extends BasePage{

    @FindBy(css = "div[class='summary_total_label']")
    WebElement totalPriceWebElement;

    @FindBy(id = "finish")
    WebElement finishButtonWebElement;

    public void clickFinishButton()
    {
        finishButtonWebElement.click();
    }

    public void validateTotalPrice(double price) {
        String expectedText = "Total: $43.18";
        String actualPrice = totalPriceWebElement.getText().replace("\\s", "");
        Assert.assertEquals(actualPrice, "Total: $" +price);
    }

}
