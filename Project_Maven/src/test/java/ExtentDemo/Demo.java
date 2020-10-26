package ExtentDemo;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	static ExtentReports reports;
	static ExtentTest test;
	@BeforeSuite
	public void startReports()
	{		
		reports = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults");
		test = reports.startTest("Extent Demo or any name");
	}
	@AfterSuite
	public void endReports()
	{
		reports.endTest(test);
		reports.flush();
	}
	@Test
	public void testDemo()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		if(driver.getTitle().equals("Googles"))
		{
			test.log(LogStatus.PASS, "Navigated to specified URL");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(getScreenShot(driver))+"Test is failed");
		}
		driver.quit();
		Assert.fail();
	
	}
	@Test(dependsOnMethods = "testDemo")
	public void testDemoB()
	{
		test.log(LogStatus.SKIP, "This method is skipped");
	}
	
	public String getScreenShot(WebDriver driver)
	{
		//Create reference of TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		//To get the screenshot
		File src = ts.getScreenshotAs(OutputType.FILE);
		//To create destination
		File dest = new File("./"+System.currentTimeMillis()+".png");
		String efile = dest.getAbsolutePath();
		try
		{
			//Copy the file from src to dest
			Files.copy(src, dest);
		} 
		catch (IOException e) 
		{
		}
		return efile;
	}
	
}
