package seleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchOptions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();// launch browser
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.name("search_query")).sendKeys("dress");
		Thread.sleep(1000);
		
		//Use below line when you have to search without for LOOP	
		
		//driver.findElement(By.xpath("//div[@class='ac_results']//li[text()='T-shirts > Faded Short Sleeve T-shirts']")).click();
	
		selectValueFromSuggestionList("T-shirts > Faded Short Sleeve T-shirts").click();;
	
	}
	
	public static WebElement selectValueFromSuggestionList(String text) {
		
				
				 return driver.findElement(By.xpath("//div[@class='ac_results']//li[text()='"+text+"']"));
	}

}
