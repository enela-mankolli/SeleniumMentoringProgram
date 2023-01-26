package training.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver = initDriver();

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver initDriver() {
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritech\\Downloads\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritech\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
