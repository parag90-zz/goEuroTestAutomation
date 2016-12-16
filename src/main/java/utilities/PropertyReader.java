package main.java.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class is for reading property file
 * @author parag
 *
 */
public class PropertyReader {

	private PropertyReader() throws Exception{
		throw new Exception("Instance creation not allowed");
	}

	/**
	 * 
	 * @param filename
	 * @return Property object
	 * @throws IOException
	 */
	public static Properties getProperty(String filename) throws IOException{
		Properties prop = new Properties();
		try {
				prop.load(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FileNotFoundException("Can't find the property file");
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		return prop;
	}
	/**
	 * 
	 * @param testCaseName
	 * @return Property
	 * @throws IOException
	 * This Method get the Property which are present in Testdata folder
	 */
	public static Properties getTestdataProprty(String testCaseName) throws IOException{
		return getProperty("./Testdata/"+testCaseName+".properties");
	}

	/**
	 * 
	 * @param PageName
	 * @return Property
	 * @throws IOException
	 */

	public static Properties getPagedataProprty(String PageName) throws IOException{
		return getProperty("./ElementRepository/"+PageName+".properties");
	}
	//For testing
/*	public static void main(String[] args) throws IOException {
		Properties prop = getProperty(null);
		System.out.println(prop.get("browser"));

	}
*/}