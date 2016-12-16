package com.goeuro.utilities;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author parag
 *
 */
public class ElementController {
	private Properties properties = null;
	private static WebDriver driver = null;
	
	public ElementController(Properties prop){
		this.properties = prop;
		driver = BrowserDriver.getDriver();
	}
	/**
	 * Method to scroll down the webpage
	 */
	public static void scrollDown(){
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
	}
	/**
	 * 
	 * @param xpath
	 * @param value
	 * @return generated Xpath
	 * This method get the xpath from property file and replace # with value
	 */
	public String getXpath(String xpath, String value){
		String Xpath = (String) properties.get(xpath);
		if(null != value)
			Xpath = Xpath.replaceAll("#", value);
		return Xpath;
	}
}
