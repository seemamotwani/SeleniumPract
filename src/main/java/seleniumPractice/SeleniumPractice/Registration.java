package seleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {

	 

	public static void main(String[] args)

	{
		String browser = "chrome";
		WebDriver driver;
		BrowerUtil br = new BrowerUtil();
		driver=br.initDriver(browser);

		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();// launch browser*/
		// System.setProperty("webDriver.chrome.driver","C:\\Users\\abhij\\Desktop\\Selenium");
		
		ElementUtil elmentutil=new ElementUtil(driver);

		driver.get("https://demo.opencart.com/index.php?route=account/register");
//creating webelements
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By emailID = By.id("input-email");
		By phoneNumber = By.name("telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By checkBox = By.name("agree");
		By submitButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By registerText = By.xpath("//*[@id=\"content\"]/h1");

		elmentutil.doSendkey(firstName, "CMAS");
		elmentutil.doSendkey(lastName, "CMAS");
		elmentutil.doSendkey(phoneNumber, "3095322564");
		elmentutil.doSendkey(emailID, "Pancha@gmail.com");
		elmentutil.doSendkey(password, "CMAS");
		elmentutil.doSendkey(confirmPassword, "CMAS");
		elmentutil.doClick(checkBox);

		if (elmentutil.isDisplayed(submitButton)) {
			elmentutil.doClick(submitButton);

		}

		else
			System.out.println("Submit button not forund");

		String expectedText = "Your Account Has Been Created!";
		if (elmentutil.getText(registerText).equals(expectedText)) {
			System.out.println(" Registration is Successful");

		} else
			System.out.println("Registration is not successful");
		
		//driver.quit();

	}


	/*public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendkey(By locator, String input) {
		getElement(locator).sendKeys(input);

	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static String getText(By locator) {
		return getElement(locator).getText();
	}

	public static boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}*/

}
