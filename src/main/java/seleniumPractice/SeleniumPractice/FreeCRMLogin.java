package seleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCRMLogin {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");
		By userName = By.name("username");
		By password = By.name("password");
		By clickButton = By.xpath("//input[@value='Login']");
		By contacts = By.linkText("CONTACTS");
		// By name=By.xpath("//a[text()='Seema
		// Mots']/parent::td/preceding-sibling::td/input[@name='contact_id']");
		By name = By.xpath(getXpath("Seema Mots"));

		getElement(userName).sendKeys("groupautomation");
		getElement(password).sendKeys("Test@12345");
		doClick(clickButton);
		driver.switchTo().frame("mainpanel");
		doClick(contacts);
		doClick(name);
		System.out.println(getContactName("Seema Mots") + " contact details are :");
		getContactDetails("Seema Mots").stream().forEach(e -> System.out.print(e + ","));

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doClick(By locator) {
		getElement(locator).click();

	}

	public static String getContactName(String contactName) {
		return driver.findElement(By.xpath("//a[text()='" + contactName + "']")).getText();
	}

	public static List<String> getContactDetails(String contactName) {
		List<String> list2 = new ArrayList<String>();

		List<WebElement> list = driver
				.findElements(By.xpath("//a[text()='" + contactName + "']/parent::td/following-sibling::td"));
		for (int i = 1; i < list.size() - 1; i++) {
			String str = list.get(i).getText();
			list2.add(str);
		}

		return list2;
	}

	public static String getXpath(String string) {
		return "//a[text()='" + string + "']/parent::td/preceding-sibling::td/input[@name='contact_id']";
	}
}
