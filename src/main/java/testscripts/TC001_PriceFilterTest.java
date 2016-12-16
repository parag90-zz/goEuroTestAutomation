package main.java.testscripts;

import java.io.IOException;
import java.util.Properties;

import main.java.utilities.SortingUtility;
import main.java.pages.MainPage;
import main.java.utilities.BrowserDriver;
import main.java.utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This testcase will test if the prices given on search results page are sorted
 *
 * @author parag
 */
public class TC001_PriceFilterTest {
    private MainPage page = null;
    private Properties testData = null;
    private WebDriver driver = null;
    private static String URL = "http://www.goeuro.com";

    /**
     * Setting up
     * 1) Browser Driver
     * 2) Navigate to URL
     * 3) initialize testData
     */
    @BeforeClass
    public void setUp() {
        try {
            driver = BrowserDriver.getDriver();
            driver.get(URL);
            page = new MainPage();
            testData = PropertyReader.getTestdataProprty("TC001_PriceFilterTest");

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    @Test
    public void test() throws InterruptedException {
        page.enterCity("departure",testData.getProperty("departureCity"));
        page.enterCity("arrival",testData.getProperty("arrivalCity"));
        page.toggleAirbnb();
        page.clickSubmit();

        //Check if the prices are sorted
        page.waitForPricesTogetLoaded();
        Assert.assertTrue(SortingUtility.isArraySorted(page.getAllPriceList()),"Prices given on page are not sorted");

    }

    /**
     * Close the Browser
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
