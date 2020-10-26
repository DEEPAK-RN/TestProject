//User should be able to create the chart with the provided name and that chart should be displayed in reports dashboard.
package Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import Generic.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiTimeCreateChart
{
	@Test
	public void actiTimeCreateChart() throws InterruptedException
	{
		String un = ReadData.getData("./src/test/resources/Data/input.xlsx", "Sheet1",0,0);
		String pw = ReadData.getData("./src/test/resources/Data/input.xlsx", "Sheet1",0,1);
//	1.Launch the Browser.	
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
//	2.Enter the URL.
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
//	3.Login with provided Credentials.
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Thread.sleep(1000);
//	4.Click on reports module.
		driver.findElement(By.xpath("//*[@id=\"container_reports\"]")).click();
		Thread.sleep(1000);
//	5.Click on Create Chart.
		driver.findElement(By.xpath("//span[contains(text(),'Create Chart')]")).click();
		Thread.sleep(3000);
//	6.Click on 'Add to DashBoard'		
		driver.findElement(By.xpath("//div[@class='addToDashboard']")).click();
		Thread.sleep(1000);
//	7.Enter the chart name which is provided.		
		driver.findElement(By.xpath("//div[contains(@class,'saveConfigurationControl newConfigEdit')]//input[contains(@placeholder,'Enter Chart Name')]")).sendKeys("Deepak's Timing's Chart");
		Thread.sleep(1000);
//	8.Click on save button.		
		driver.findElement(By.xpath("//td[@class='saveNewConfigButton greyButton']//div[@class='buttonIcon']")).click();
		Thread.sleep(1000);
//	9.Click on close button.		
		driver.findElement(By.id("createChartLightbox_cancelBtn")).click();
		Thread.sleep(1000);
// To scroll the web page 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
// call the executeScript method, This  will scroll down the page by  1000 pixel vertical	
	     js.executeScript("window.scrollBy(0,1000)");
	  }
}