package seleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRMRegistration {

	public static void main(String[] args) {
		String browser = "chrome";
		WebDriver driver;
		BrowerUtil br = new BrowerUtil();
		driver=br.initDriver(browser);
		
		ElementUtil elmentutil=new ElementUtil(driver);

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		
		By firstName = By.xpath("//*[@id=\"Form_submitForm_FirstName\"]");
		By lastName=By.xpath("//*[@id=\"Form_submitForm_LastName\"]");
		By email=By.name("Email"); 
		By jobTitle=By.id("Form_submitForm_JobTitle");
		By companyName=By.name("CompanyName");
		By contactPhone=By.cssSelector("#Form_submitForm_Contact");
		By checkBox=By.xpath("//*[@id=\"Form_submitForm_SetDummyData\"]");
		By countrySelection=By.id("Form_submitForm_Country");
		
		

	}

}
