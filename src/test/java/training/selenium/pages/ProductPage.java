package training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import training.selenium.utils.DriverFactory;
import training.selenium.utils.WebElementUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage() {
    }

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]/div[2]/div[@class='pricebar']/button")
    WebElement addToCartButtonProduct1;

    @FindBy(xpath = "//div[@class='inventory_list']/div[2]/div[2]/div[@class='pricebar']/button")
    WebElement addToCartButtonProduct2;

    public void addToCardProducts() {
        WebElementUtils.clickWebElement(addToCartButtonProduct1);
        WebElementUtils.clickWebElement(addToCartButtonProduct2);
    }

    public void logout() {
        WebElementUtils.clickWebElement(DriverFactory.getDriver().findElement(By.id("react-burger-menu-btn")));
        WebElementUtils.clickWebElement(DriverFactory.getDriver().findElement(By.id("logout_sidebar_link")));
    }

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement shoppingCardBadge;

    public void validateNumberOfChosenProducts(int expectedNrOfProducts) {
        int actualNrOfProducts = Integer.parseInt(shoppingCardBadge.getText());
        Assert.assertEquals(actualNrOfProducts, expectedNrOfProducts);
    }

    public void clickShoppingCardBadge() {
        WebElementUtils.clickWebElement( shoppingCardBadge);
    }

    public List<String> getProductsName() {
        List<String> list = new ArrayList<>();
        By by = By.xpath("//div[@class='inventory_item_label']/a/div");
        List<WebElement> elements = DriverFactory.getDriver().findElements(by);

        for (WebElement el : elements) {
            list.add(el.getText());
        }
        return list;
    }
}
