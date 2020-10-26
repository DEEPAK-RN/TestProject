package ServicesRTO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RTO_DL_Services {
	@Test
	public void AccessApplication() throws InterruptedException
	{
		String un = ReadData.getData("./src/test/resources/Data/input.xlsx", "Sheet1",0,0);
		String pw = ReadData.getData("./src/test/resources/Data/input.xlsx", "Sheet1",0,1);
//	1.Launch the Browser.	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		2.Enter the URL.
		driver.get("https://parivahan.gov.in/parivahan/");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Online Servic")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Driving License Rela")).click();
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.id("stfNameId")));
		Thread.sleep(2000);
		state.selectByVisibleText("Karnataka");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Apply Online')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='active has-sub open']//li[5]//a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='bdheight']//input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("dlno")).sendKeys("KA25 20160009652");
		Thread.sleep(2000);
		driver.findElement(By.id("dob")).sendKeys("15-07-1989");
		Thread.sleep(2000);
		driver.findElement(By.className("btn btn-sm")).click();
		Thread.sleep(2000);
		Select y = new Select(driver.findElement(By.id("dispDLDet")));
		y.selectByVisibleText("Yes");
		Thread.sleep(2000);
		Select state1 = new Select(driver.findElement(By.id("stateCodeDLTr")));
		state1.selectByVisibleText("Karnataka");
		Thread.sleep(2000);
		Select rto = new Select(driver.findElement(By.id("rtoCodeDLTr")));
		rto.selectByVisibleText("DHARWAD -- KA25");
		Thread.sleep(2000);
		driver.findElement(By.id("dlconfirm")).click();
		
		driver.findElement(By.id("envaction_enve_confirm")).click();
		driver.findElement(By.id("trsaction_enve_proceed")).click();
}
}