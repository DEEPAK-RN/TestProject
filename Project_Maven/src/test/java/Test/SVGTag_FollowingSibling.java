package Test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGTag_FollowingSibling
{
	@Test
	public void testA() throws InterruptedException, AWTException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Adarsh%20R%20N/Downloads/SVG.html");
		List<WebElement> lines = driver.findElements(By.xpath("//*"));
		System.out.println(lines.size());
		int count = 0;
		Actions act = new Actions(driver);
		for(WebElement lin : lines)
		{
			String tname = lin.getTagName();
			if(tname.equals("line"))
			{
				count++;
				String bfcolor = lin.getCssValue("stroke");
				System.out.println("Before placing couser "+bfcolor);
				act.moveToElement(lin).perform();
				Thread.sleep(3000);
				String afcolor = lin.getCssValue("stroke");
				System.out.println("After placing couser "+afcolor);
				System.out.println("-----------------------------------------");
				WebElement tooltip = lin.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				String text = tooltip.getText();
				System.out.println(text);
				System.out.println("===================================");
			}
			
		}
		System.out.println("Total lines present "+count);
		Thread.sleep(2000);
		driver.quit();
		
	}

}