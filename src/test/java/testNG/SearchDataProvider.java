package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchDataProvider extends BaseTest {

	public void doLogin() {
		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@DataProvider
	public Object[] getSerachData() {
		return new Object[] { "Computer", "laptop", "DVD" };
	}

	@Test(dataProvider = "getSerachData")

	public void multiSearch(String searchData) {
		By search = By.name("search");
		By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
		By searchText = By.cssSelector("#content > h1");
		doSendkey(search, searchData);
		getElement(searchButton).click();
		String actuaresult = getElement(searchText).getText();
		String expectedResult = "Search - " + searchData;
		Assert.assertEquals(actuaresult, expectedResult);
		getElement(search).clear();

	}

	public void doSendkey(By locator, String input) {
		getElement(locator).sendKeys(input);

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
