package Generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
import org.openqa.selenium.TakesScreenshot;

public class GenericUtils {
	
	public static void getScreenShot(WebDriver driver, String name)
	{
		
		Date d = new Date();
		String date = d.toString().replaceAll(":","_");
		TakesScreenshot take = (TakesScreenshot) driver;		
		File src = take.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+name+"_"+date+".png");
		try
		{
		Files.copy(src, dest);
		}
		catch (IOException e)
		{
	    }
	}
}
