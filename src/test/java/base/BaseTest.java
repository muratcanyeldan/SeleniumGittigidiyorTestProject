package base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import utils.Constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BaseTest {

    private static WebDriver driver;
    protected static HomePage homePage;

    @BeforeClass
    public static void setUp(){
        if (driver != null)
            return;
        System.setProperty(Constants.DRIVER_PROPERTY_NAME, Constants.DRIVER_LOCATION);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get(Constants.BASE_URL);
        assertEquals(Constants.BASE_URL,driver.getCurrentUrl());

        if(homePage != null)
            return;
        homePage = new HomePage(driver);
    }

    @AfterClass
    public static void closeConnection(){
        driver.quit();
    }
}
