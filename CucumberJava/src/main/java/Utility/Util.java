package Utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.DriverManager;

public class Util extends DriverManager {

	static FileReader reader;
	static Properties p;
	
	public static byte[] takeScreenShot() {
		return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
	}

	public static String properties(String fileName, String value) {
		String propValue = null;
		try {
			reader = new FileReader("AppConfig" + "//" + fileName + ".properties");
			p = new Properties();
			p.load(reader);
			propValue = p.getProperty(value);
		} catch (FileNotFoundException e) {
			new RuntimeException("File is not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			new RuntimeException("IO exception occured");
		}
		return propValue;
	}

	public static void sendText(WebElement element, String value) {
		element.click();
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getURL() {
		return webDriver.get().getCurrentUrl();
	}

	public static void sendKeys(WebElement element, Keys return1) {
		element.sendKeys(return1);
		
	}
	
	public static void doubleclick(WebElement element) {
	    Actions act = new Actions(webDriver.get());
	    act.doubleClick(element).perform(); 
		
	}

	public static void sendKeys(WebElement elt, String chord) {
		elt.sendKeys(chord);
		
	}
}