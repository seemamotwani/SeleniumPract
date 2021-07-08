package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativetest extends BaseTest{
	
	@DataProvider
	public Object[][] getLoginNegativeData() {
		
		return  new Object[][] {
			{"sdsds@gmail.com","12334"},
			{ "   ","  "},
			{ "","Test@12345"}
		};
	}
	
	@Test(dataProvider="getLoginNegativeData")
	public void doLogin(String username, String password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(
				driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible"))
				.isDisplayed());

}
}