
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class RoughWork {

	public static void main(String[] args) throws InterruptedException, IOException   {
		// T95ODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
		String productName = "ADIDAS ORIGINAL";
	
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("tariq.najib.khan@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("B777300er?");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products = driver.findElements(By.cssSelector(".offset-sm-1"));
		WebElement prod = products.stream().filter(i->i.findElement(By.tagName("b")).getText().contains(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".toast-message"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean buy = cartItems.stream().anyMatch(i->i.getText().contains(productName));
		
		Assert.assertTrue(buy);
		
		driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("uni");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item")));
		
		List<WebElement> countries = driver.findElements(By.cssSelector(".list-group-item"));
		WebElement myCntry = countries.stream().filter(i->i.getText().contains("United Kingdom")).findFirst().orElse(null);
		myCntry.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		String orderConfirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(orderConfirm, "THANKYOU FOR THE ORDER.");
		driver.quit();
		
		
		
		
		
		
		////select[@class='input ddl'] [2]
		
		
		

		
	}

}
