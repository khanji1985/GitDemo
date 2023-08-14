import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9));
		
		
		String date = "19";
		String month = "June";
		driver.get("https://www.britishairways.com/");
		driver.findElement(By.id("content")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='date h1 ng-binding']")));
		driver.findElement(By.cssSelector("div[class='date h1 ng-binding']")).click();
		
		while(!driver.findElement(By.cssSelector("span[class*='month-name']")).getText().contains(month))
		{
			driver.findElement(By.cssSelector(".move-month.next-month")).click();
		}
		
		
		
		
		
		
		
		
//.move-month.next-month
		//span[class*='month-name']
		//date - span[data-bo-text='day.date.date()']
	// calendar - div[class='date h1 ng-binding']
	}
}


