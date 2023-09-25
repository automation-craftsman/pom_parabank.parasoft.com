package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public Base(){
        loadProperties();
    }

    public static WebDriver driver;
    public static Properties prop;

    private static final ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    /**
     * Setter and Getter for WebDriver in ThreadLocal where
     * @param driver will set the user specific driver
     */
    private static void setDriver(WebDriver driver){
        tDriver.set(driver);
    }
    private static WebDriver getDriver(){
        return tDriver.get();
    }

    /**
     *
     * @param browserName will define which browser to launch and will
     * @return a WebDriver object
     */
    private static WebDriver launchBrowser(String browserName){

        // Reference browser options object for future development
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (browserName.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver(chromeOptions);
            setDriver(driver);

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver(firefoxOptions);
            setDriver(driver);

        }else {
            System.out.println("[!] Invalid browser name. Launching Chrome as default.");
            driver = new ChromeDriver(chromeOptions);
            setDriver(driver);
        }

        return getDriver();
    }

    /**
     * Function to load the properties file
     */
    private static void loadProperties() {

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    "\\src\\test\\resources\\baseConfig.properties");

            prop.load(fis);

        } catch (IOException e) {
            System.out.println("[!] Error loading the baseConfig file.");
            System.out.println("Error caused by: " + e.getCause());
            e.printStackTrace();
        }
    }

    /**
     * This function will launch before a test or the entire test suite based on necessity
     */
    @BeforeSuite
    public static synchronized void setUp(){
        driver = launchBrowser(prop.getProperty("browser"));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * This function will launch after a test or and entire test suite based on necessity
     */
    @AfterSuite
    public static void cleanUp(){
        if (getDriver() != null){
            getDriver().quit();
        }
    }

}
