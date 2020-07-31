package handling_Tables;

// Q)WAS print only numbers present in the table?
// Q)WAS to add all the numbers displayed

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintOnlyNumbers
{
	@Test
	public void testA() 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Desktop/Tables_SampleWebPage.html");
		List<WebElement> allNumbers = driver.findElements(By.xpath("//td"));
		int count = allNumbers.size();
		int c = 0;
		int sum = 0;
		for(int i =0; i<count; i++)
		{
			WebElement cell = allNumbers.get(i);
			String text = cell.getText();
			try
			{
				int n = Integer.parseInt(text);
				System.out.println(n);
				c++;
				sum = sum+n;
			}
			catch (Exception e) 
			{				
			}
		}
		System.out.println("Total numbers prents in the table "+c);
		System.out.println("And the Sum of all the numbers "+sum);
		driver.close();
	}
}
