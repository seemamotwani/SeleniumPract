package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	//public WebDriver driver;
	
	@Test
	public void accountPageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "Account Login");
	}

	
	

}
