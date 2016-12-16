package main.java.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import main.java.utilities.BrowserDriver;
import main.java.utilities.ElementController;
import main.java.utilities.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class deals with the main page
 *
 * @author parag
 */
public class MainPage {
    private WebDriver driver = null;
    private Properties properties = null;
    private ElementController controller = null;

    public MainPage() throws IOException {
        driver = BrowserDriver.getDriver();
        properties = PropertyReader.getPagedataProprty("MainPage");
        controller = new ElementController(properties);
    }

    public void enterCity(String type, String city) {
        if (type.equalsIgnoreCase("departure")) {
            driver.findElement(By.xpath(properties.getProperty("departureCity"))).sendKeys(city);
            driver.findElement(By.xpath(properties.getProperty("departureCity"))).sendKeys(Keys.TAB);
        } else if (type.equalsIgnoreCase("arrival")) {
            driver.findElement(By.xpath(properties.getProperty("arrivalCity"))).sendKeys(city);
            driver.findElement(By.xpath(properties.getProperty("departureCity"))).sendKeys(Keys.TAB);
        }

    }

    public boolean isHomePage() {
        boolean isHomePage = false;
        if (driver.getTitle().contains("Search & Compare")) {
            isHomePage = true;
        }
        return isHomePage;
    }

    public void toggleAirbnb() {
        driver.findElement(By.xpath(properties.getProperty("searchAirbnb"))).click();
    }

    public void clickSubmit() throws InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(By.xpath(properties.getProperty("search")));
        element.click();
        if (isHomePage()) {
            element = driver.findElement(By.xpath(properties.getProperty("search")));
            Thread.sleep(500);
            element.click();
        }
    }

    public void waitForPricesTogetLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("prices"))));
    }

    public ArrayList<Integer> getAllPriceList() {
        List<WebElement> elements = driver.findElements(By.xpath(properties.getProperty("prices")));
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for (WebElement element : elements) {
            prices.add(Integer.parseInt(element.getText()));
        }
        System.out.println(prices);
        return prices;
    }
}
