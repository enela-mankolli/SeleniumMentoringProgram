package training.selenium.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver = initDriver("chrome");

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver initDriver(String browserType) {
        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
            driver = new FirefoxDriver(options);

        } else if (browserType.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
