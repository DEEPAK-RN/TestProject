package handling_Tables;

// Q)WAS to print only text present in the tables?

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintOnlyText
{
	@Test
	public void testA() 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Desktop/Tables_SampleWebPage.html");
		List<WebElement> allTexts = driver.findElements(By.xpath("//td"));
		int count = allTexts.size();
		
		int c = 0;
		for(int i =0; i<count; i++)
		{
			WebElement cell = allTexts.get(i);
			String text = cell.getText();
			try
			{
				int n = Integer.parseInt(text);
			}
			catch (Exception e) 
			{
				System.out.println(text);
				c++;
			}
		}
		System.out.println("\nTotal No.of texts displayed: "+c);
		driver.close();
	}
}
