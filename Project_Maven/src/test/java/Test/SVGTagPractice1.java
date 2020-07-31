package Test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGTagPractice1
{
	@Test
	public void testA() throws InterruptedException, AWTException, IOException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Downloads/svgdemo.html");
		List<WebElement> circles = driver.findElements(By.xpath("//*"));
		System.out.println("Total elements present "+circles.size());
		int count = 0;
		int green = 0;
		int red = 0;

		for(WebElement cir : circles)
		{
			String tname = cir.getTagName();
			if(tname.equals("circle"))
			{
				count++;
				String color = cir.getAttribute("fill-opacity");
				System.out.println(color);
				if(color.equals("0.5"))
				{
					green++;
				}
				else
				{
					red++;
				}
			}
			
		}
		System.out.println("Total circles present "+count);
		System.out.println("Green circles "+green);
		System.out.println("Red circles "+red);
		driver.quit();
		
	}

}