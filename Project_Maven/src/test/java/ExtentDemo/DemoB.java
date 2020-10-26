package ExtentDemo;

import java.util.Date;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class DemoB extends Demo {
	
	@Test
	public void testDemoC()
	{
		
		test.log(LogStatus.FAIL, "This mathod failed");
		Assert.fail();
	}
	@Test
	public void testDemoD() throws InterruptedException
	{
		Date startTime = test.getStartedTime();
		Reporter.log("Start time "+startTime,true);
		test.log(LogStatus.INFO, "Test method information");
		
		Date endTime = test.getEndedTime();
		Thread.sleep(2000);
		
		Reporter.log("Start time "+endTime,true);
		LogStatus status = test.getRunStatus();
		Reporter.log("Start time "+status,true);
		
	}

}
