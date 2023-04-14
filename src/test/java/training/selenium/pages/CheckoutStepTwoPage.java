package training.selenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import training.selenium.utils.WebElementUtils;

public class CheckoutStepTwoPage extends BasePage{

    @FindBy(css = "div[class='summary_total_label']")
    WebElement totalPriceWebElement;

    @FindBy(id = "finish")
    WebElement finishButtonWebElement;

    public void clickFinishButton()
    {
        WebElementUtils.clickWebElement(finishButtonWebElement);
    }

    public String getTotalPrice() {
        return totalPriceWebElement.getText().replace("\\s", "");
    }

}
