package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * 1. Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        System.setProperty("WebDriver.Chrome.driver", "driver/ ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        //Maximize window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowse() {
        driver.quit();
    }
}
