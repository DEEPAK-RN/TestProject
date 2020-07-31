package handling_Tables;

// Q) WAS to count no of tables present in the webpage?

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountTables
{
	@Test
	public void testA() 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Desktop/Tables_SampleWebPage.html");
		List<WebElement> allTables = driver.findElements(By.xpath("//table"));
		int count  = allTables.size();
		System.out.println(count+" Tables");
		driver.close();
		
	}

}
