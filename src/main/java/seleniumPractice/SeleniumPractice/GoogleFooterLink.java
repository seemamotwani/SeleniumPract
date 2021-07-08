package seleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleFooterLink {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		// By footerLink=By.xpath("//div[@class='KxwPGc SSwjIe']//a");
		By footerLinks = By.xpath("//div[@class='KxwPGc SSwjIe']//a[@class='pHiOh']");

		//doClickFooterLinks(footerLinks, "Carbon neutral since 2007", "Terms");
		doClickFooterLinks(footerLinks, "automation_all");

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public static void doClickFooterLinks(By locator, String... value) {
		List<WebElement> footerLinkList = getElements(locator);
		//System.out.println("Total Footer Links: " + footerLinkList.size());
		if (!(value[0].equals("automation_all"))) {
			for (int i = 0; i < footerLinkList.size(); i++) {
				String text = footerLinkList.get(i).getText();

				for (int j = 0; j < value.length; j++) {
					if (text.equalsIgnoreCase(value[j])) {
						System.out.println(text);
						footerLinkList.get(j).click();
						driver.navigate().back();
						footerLinkList = getElements(locator);// to override Stale element exception
						break;
					}
				}

			}

		}

		else {
			System.out.println("Total Footer Links: " + footerLinkList.size());
			for (int m = 0; m < footerLinkList.size(); m++) {
		
				System.out.println(footerLinkList.get(m).getText());
				footerLinkList.get(m).click();
				driver.navigate().back();
				footerLinkList = getElements(locator);// to override Stale element exception
			}

		}

	}

}
