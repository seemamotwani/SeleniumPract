package seleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDown {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		By choices = By.cssSelector("span.comboTreeItemTitle");
		// choiceSelection(choices, "choice 1");// single selection
		choiceSelection(choices, "choice 1", "choice 2");// multiselection
		choiceSelection(choices, "all");// change"all" to automation_all else it will fail when dropdown has option as
										// 'All'
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	// this works with single selection
	public static void choiceSelection(By locator, String value) {
		List<WebElement> choiceList = getElements(locator);
		System.out.println(choiceList.size());
		for (WebElement e : choiceList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}

		}

	}

	// multiselection
	public static void choiceSelection(By locator, String... value) {
		List<WebElement> choiceList = getElements(locator);

		if (!(value[0].equalsIgnoreCase("all"))) {

			System.out.println(choiceList.size());
			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);
				for (String s : value) {
					if (text.equals(s)) {
						e.click();
						break;
					}

				}

			}
		} else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {
				System.out.println("All options selected");
			}
		}
	}
}
