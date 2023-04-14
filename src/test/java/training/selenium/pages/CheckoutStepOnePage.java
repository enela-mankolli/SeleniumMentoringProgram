package training.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import training.selenium.utils.DriverFactory;
import training.selenium.utils.WebElementUtils;

public class CheckoutStepOnePage extends BasePage {

    JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();

    @FindBy(id = "first-name")
    WebElement firstNameWebElement;
    @FindBy(id = "last-name")
    WebElement lastNameWebElement;

    @FindBy(id = "postal-code")
    WebElement postalCodeWebElement;

    @FindBy(id = "continue")
    WebElement continueButtonWebElement;

    public void completeForm(String firstName, String lastName, String postalCode) {
        WebElementUtils.typeInElement(firstNameWebElement,firstName);
        WebElementUtils.typeInElement(lastNameWebElement,lastName);
        WebElementUtils.typeInElement(postalCodeWebElement,postalCode);
    }
    public void clickContinueButton() {
        WebElementUtils.clickWebElement(continueButtonWebElement);
    }
}
