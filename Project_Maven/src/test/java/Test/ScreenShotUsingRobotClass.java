package Test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotUsingRobotClass 
{
	@Test
	public void testA() throws InterruptedException, AWTException, IOException
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[4]")).click();
		driver.findElement(By.linkText("Contact actiTIME Support")).click();
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		Thread.sleep(3000);
		
		Robot r = new Robot();
		
		// get the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		//create object of rectangle class
		Rectangle rect = new Rectangle(d);
		BufferedImage img = r.createScreenCapture(rect);
		
		//to store in prefered location
		ImageIO.write(img, "png", new File("./screenstot.png"));
		
		r.keyPress(KeyEvent.VK_ESCAPE);
	
		Thread.sleep(2000);
		driver.quit();
	}

}