package com.goeuro.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * This is singleton class, only single object will be created in lifetime
 *
 * @author parag
 */
public class BrowserDriver {

    private static WebDriver driver = null;

    private BrowserDriver() throws Exception {
        throw new Exception("Object Creation Not allowed");
    }

    /**
     * @return driver
     * This method initilize driver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (BrowserDriver.class) {
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "Setup/chromedriver2");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    driver = new ChromeDriver(options);
                    //driver.manage().window().maximize();
                    //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                }
            }
        }
        return driver;
    }
}
