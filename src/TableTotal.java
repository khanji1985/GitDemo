import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTotal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		js.executeScript("window.scrollBy(0, 600)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0, 500)");
		List<WebElement> values = driver.findElements(By.xpath(".//div[@class='tableFixHead']//td[4]"));
		
		int sum = 0;
		
		for(int i=0; i<values.size(); i++)
		{
		     String retrValue = values.get(i).getText();
		     int finalValue = Integer.parseInt(retrValue);
		     
		     sum = sum + finalValue;
			
		}
		
		System.out.println(sum++);
		
		//System.out.println(total);
		
		//both works
		
	}

}
