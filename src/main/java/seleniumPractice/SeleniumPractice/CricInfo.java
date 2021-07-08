package seleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfo {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/kwibuka-women-s-twenty20-2021-1265208/kenya-women-vs-namibia-women-7th-match-1265219/full-scorecard");

		String bowlerName="Melvin Idambo";
	
		System.out.println(getBowlerName(bowlerName)+" :");		
				
		getBowlingScoreCard(bowlerName).stream().forEach(e->System.out.println(e+ ""));;
		
		//System.out.print(getWicketTakerName("Sune Wittmann") + " : ");

		//getScoreCard("Sune Wittmann").stream().forEach(e -> System.out.print(e + " "));
		

	}
	

	public static List<String> getBowlingScoreCard(String bowlerName) {
		List<WebElement> scoreList = driver
				.findElements(By.xpath("//a[text()='"+bowlerName+"']/parent::td[@class='text-nowrap']//following-sibling::td"));

		List<String> scoreList2 = new ArrayList<String>();

		for (int i = 0; i < scoreList.size() ; i++) {
			String text = scoreList.get(i).getText();
			// System.out.println(text);		
			 
			 if(!text.isEmpty()) {
					scoreList2.add(text);
				}
			 
//			 if(text.substring(0,2).equals(" ")){
//				 continue;
//			 }
			 /*if(!("".equals(text))) {
				 scoreList2.add(text);
				 //text.substring(0,2).equals(" ")||(text.isEmpty()))
			 }*/
		}

		return scoreList2;

	}
	
	public static String getXpath(String bowlerName) {
		return "//a[text()='"+bowlerName+"']";
				
	}

	public static String getBowlerName(String bowlerName) {
		return driver
				.findElement(
						By.xpath(getXpath(bowlerName)))
				.getText();
	}

}
