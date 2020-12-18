package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;
            case "safari":
                tlDriver.set(new SafariDriver());
                break;
            default:
                System.out.println("Please pass the correct browser value: " + browser);
                break;
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
