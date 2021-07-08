package seleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdwon {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();// launch browser
		System.setProperty("webDriver.chrome.driver", "C:\\Users\\abhij\\Desktop\\Selenium");

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//creating webelements
		By firstName = By.xpath("//*[@id=\"Form_submitForm_FirstName\"]");
		By lastName=By.xpath("//*[@id=\"Form_submitForm_LastName\"]");
		By email=By.name("Email"); 
		By jobTitle=By.id("Form_submitForm_JobTitle");
		By companyName=By.name("CompanyName");
		By contactPhone=By.cssSelector("#Form_submitForm_Contact");
		By checkBox=By.xpath("//*[@id=\"Form_submitForm_SetDummyData\"]");
		By countrySelection=By.id("Form_submitForm_Country");
		By industrySelection=By.id("Form_submitForm_Industry");
		
		doSendkey(firstName,"Seems");
		doSendkey(lastName,"Seems");
		doSendkey(email,"Seems@gmail.com");
		doSendkey(jobTitle,"Engineer");
		doSendkey(companyName,"Seems");
		doSendkey(contactPhone,"319-531-5837");
		doGetDropdownValue(industrySelection,"Education");
		doGetDropdownValue(countrySelection,"India");
		
		//getElement(checkBox).click();
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendkey(By locator, String input) {
		getElement(locator).sendKeys(input);

	}
/**
 * This method is using getoption to get dropdown value and, click on desired value
 * @param locator
 * @param value
 */
	public static void doGetDropdownValue(By locator, String value) {
		
		//List<String> optionTextList = new ArrayList<String>();
		Select sel = new Select(getElement(locator));
		List<WebElement> optionList = sel.getOptions();
	

		for (WebElement e : optionList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
			break;	
			
			}
		}
	}
	
	//dropdown without Select class
	
}