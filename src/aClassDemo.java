import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class aClassDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.xpath("(//a[normalize-space()='Courses'])[1]")).click();
		
		driver.switchTo().defaultContent();
		
		//System.out.println(driver.findElements(By.tagName("a")).size());
		
		//WebElement subDriver = driver.findElement(By.id("gf-BIG"));
		
		//System.out.println(subDriver.findElements(By.tagName("a")).size());
		
		WebElement subDriver1 = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(subDriver1.findElements(By.tagName("a")).size());
		
		List<WebElement> links = subDriver1.findElements(By.tagName("a"));
		
		for(int i=1; i<links.size(); i++)
		{
			String action = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			links.get(i).sendKeys(action);
		}
		
		Thread.sleep(9000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
		
		System.out.println("Job Done");
		System.out.println("Thank you");
		
		
		
}

}