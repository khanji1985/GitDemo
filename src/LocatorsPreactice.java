import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LocatorsPreactice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();		
		String[] items = {"Beetroot", "Strawberry", "Grapes", "Almonds",};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		getItems(driver,items);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		WebElement selectCountry = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
		Select dropDown =new Select(selectCountry);
		dropDown.selectByVisibleText("United Kingdom");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button")).click();
		

}

	

	public static void getItems(WebDriver driver, String[] items)
	{
		int f = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++)
		{
			String name = products.get(i).getText();
			name.split(" ");
			String formattedName = name.split(" ")[0];
			List<String> itemsNeeded = Arrays.asList(items);
			
			if(itemsNeeded.contains(formattedName))
			{
				f++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(f==itemsNeeded.size())
				{
					break;
				}
			}
			
		}
	}
}
