package Test;


import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Reporter;

public class Demo
{
	@Test
	public void testA()
	{
		Reporter.log("Maven Demo..",true);
	//	Assert.fail();
	}
}
