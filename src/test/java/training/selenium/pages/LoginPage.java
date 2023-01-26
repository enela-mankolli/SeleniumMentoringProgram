package training.selenium.pages;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import training.selenium.utils.DriverFactory;

import java.time.Duration;

public class LoginPage extends BasePage {

    String expectedUrl = "https://www.saucedemo.com";

    public LoginPage() {
    }

    @FindBy(id = "user-name")
    WebElement usernameWebElement;

    @FindBy(id = "password")
    WebElement passwordWebElement;

    @FindBy(id = "login-button")
    WebElement loginButtonWebElement;

    public void enterCredentials(String username, String password) {
        usernameWebElement.clear();
        usernameWebElement.sendKeys(username);
        passwordWebElement.clear();
        passwordWebElement.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButtonWebElement.click();
    }

    public void login(String username, String password) {
        enterCredentials(username, password);
        clickLoginButton();
    }

    public void checkInvalidLoginMessage(String expectedErrorMessage) {
        WebDriverWait explicitWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        By by = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
        explicitWait.until(ExpectedConditions.textToBe(by, expectedErrorMessage));
        WebElement errorMessageElement = DriverFactory.getDriver().findElement(by);
        String currentErrorMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedErrorMessage, currentErrorMessage);
    }
}
