package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utility.Util;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	

	@BeforeSuite
	public static void CreateDriver() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(Util.properties("config", "Applink"));
		driver.manage().window().maximize();
		webDriver.set(driver);
	}

	@AfterSuite
	public synchronized void afterSuite() throws IOException {
		webDriver.get().close();
		webDriver.get().quit();
	}
	

}