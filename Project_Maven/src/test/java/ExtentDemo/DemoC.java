package ExtentDemo;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class DemoC {
	
	private static final Logger logger = Logger.getLogger(Demo.class);
	
	@Test
	public void test()
	{
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("this is warning message");
		logger.error("This is error message");
		System.out.println("Log4j executed successfully..");
	}
}
