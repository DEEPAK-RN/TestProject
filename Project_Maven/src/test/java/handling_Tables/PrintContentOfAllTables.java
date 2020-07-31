package handling_Tables;

// Q)WAS to print content of all the tables?

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintContentOfAllTables 
{
	@Test
	public void testA() 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Desktop/Tables_SampleWebPage.html");
		List<WebElement> allContents = driver.findElements(By.xpath("//td"));
		int count  = allContents.size();
		System.out.println("Number of Contents "+count);
		for(int i =0; i<count; i++)
		{
			WebElement cell = allContents.get(i);
			String text = cell.getText();
			System.out.println(text);
		}
		driver.close();
		
	}

}
