package training.selenium.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import training.selenium.utils.DriverFactory;

import java.time.Duration;

public class BasePage {

    public BasePage() {

        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void validateURL(String expectedUrl) {

        WebDriverWait explicitWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

}
