package training.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import training.selenium.utils.DriverFactory;

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
        firstNameWebElement.clear();
        firstNameWebElement.sendKeys(firstName);
        lastNameWebElement.clear();
        lastNameWebElement.sendKeys(lastName);
        postalCodeWebElement.sendKeys(postalCode);

    }
    public void clickContinueButton() {
        continueButtonWebElement.click();
    }
}
