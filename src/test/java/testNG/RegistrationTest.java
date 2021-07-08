package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
@DataProvider
	public Object[][] getRegistrationData() {
		return new Object[][] { { "seem", "test", "aunty@gmail.com", "398-987-8976", "dntKnow@12" },
				{ "see", "test2", "aunty35@gmail.com", "398-987-9976", "dntKnow@12" },
				{ "third", "test3", "aynty90@gmail.com", "398-987-9976", "dntKnow@13" }, };

	}

	@Test(dataProvider="getRegistrationData")
	public void registration(String firstname, String lastname, String emailid, String telephone,
			String registerpassword) {
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		String expectedText = "Your Account Has Been Created!";
		// creating webElements
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By emailID = By.id("input-email");
		By phoneNumber = By.name("telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By checkBox = By.name("agree");
		By submitButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By registerText = By.xpath("//*[@id=\"content\"]/h1");
		doSendkey(firstName, firstname);
		doSendkey(lastName, lastname);
		doSendkey(emailID, emailid);
		doSendkey(phoneNumber, telephone);
		doSendkey(password, registerpassword);
		doSendkey(confirmPassword, registerpassword);
		getElement(checkBox).click();
		getElement(submitButton).click();
		String actualResult = getElement(registerText).getText();
		Assert.assertEquals(actualResult, expectedText);
	}

	public void doSendkey(By locator, String input) {
		getElement(locator).sendKeys(input);

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
