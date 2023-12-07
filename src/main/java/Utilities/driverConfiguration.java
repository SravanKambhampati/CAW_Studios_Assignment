package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverConfiguration {
/**
 * This method initializes the Chrome webdriver
 * @return WebDriver instance
 */
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
