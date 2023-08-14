import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavaPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		String date = "19";
		String month = "May 2023 June 2023";
		driver.get("https://www.expedia.co.uk/");
		driver.findElement(By.cssSelector("button[class*='type_accept']")).click();
		driver.findElement(By.cssSelector("button[id='d1-btn']")).click();		
		while(!driver.findElement(By.cssSelector("div[class*='menu-pagination']")).getText().contains(month))
	
		{
			driver.findElement(By.xpath("(//button[@data-stid='date-picker-paging'])[2]")).click();
		}
	
		
		//(//div[@class='uitk-date-picker-month'])[2]
	
	}
}

