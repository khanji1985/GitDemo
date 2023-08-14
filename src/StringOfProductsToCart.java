import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringOfProductsToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] desiredProdcuts = {"Cucumber", "Capsicum", "Strawberry"};
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		List<WebElement> prodDisplay = driver.findElements(By.cssSelector(".product-name"));
		
		for(int i=0; i<prodDisplay.size(); i++)
		{
			String productText = prodDisplay.get(i).getText();
			String product = productText.split(" ")[0];
			
			List<String> shoppingList = Arrays.asList(desiredProdcuts);
			
			if(shoppingList.contains(product))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				
			}
		}

	}

}
