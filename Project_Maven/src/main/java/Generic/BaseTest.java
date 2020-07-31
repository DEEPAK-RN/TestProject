package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements Autoconstant
{
	public WebDriver driver;
	
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	@BeforeMethod
	public void precondition()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://demo.actitime.com");
	}
	@AfterMethod
	public void Postcondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status == 2)
		{
			String name = res.getName();
			GenericUtils.getScreenShot(driver, name);
		}
		driver.quit();
	}
}