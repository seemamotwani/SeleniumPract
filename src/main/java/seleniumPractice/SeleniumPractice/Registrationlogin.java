package seleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registrationlogin {
	static WebDriver driver;
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		  driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		  driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		  driver.findElement(By.xpath("//input[@value='Login']"));


	}

}
