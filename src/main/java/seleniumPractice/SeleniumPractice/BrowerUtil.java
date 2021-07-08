package seleniumPractice.SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowerUtil {

	public WebDriver driver;

	/**
	 * This method is used to init the driver on the basis of browser name.
	 * 
	 * @param browserName
	 * @return this will return driver
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name : " + browserName);

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Plase pass the right browser : " + browserName);
			break;
		}

		return driver;
	}
}
