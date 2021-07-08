package seleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doSendkey(By locator, String input) {
		getElement(locator).sendKeys(input);

	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}


	public void doClick(By locator) {
		getElement(locator).click();
		
	}
	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public List<String> doGetAllDropdownOption(By locator) {
		List<String> optionTextList = new ArrayList<String>();
		Select sel = new Select(getElement(locator));
		List<WebElement> optionList = sel.getOptions();
		// sel.selectByVisibleText("Automative");
		
		optionList.size();
		for (WebElement e:optionList) {
			String text=e.getText();
			optionTextList.add(text);
		}
		return optionTextList;
	}

}
